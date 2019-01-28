selectByAll
===
	select * from people
	

selectByName
===
	select * from people where 1=1
	@if(!isEmpty(name)){
		and name = #name#
	}
		
selectByPage
===
	select 
	@pageTag(){
		p.*
	@}
	from people p	
	where name = #name#