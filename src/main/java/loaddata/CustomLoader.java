package loaddata;


import org.easetech.easytest.loader.XMLDataLoader;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.easetech.easytest.io.FileSystemResource;
import org.easetech.easytest.io.Resource;

public class CustomLoader extends XMLDataLoader{

	@Override
	public Map<String, List<Map<String, Object>>> loadData(Resource resource) {
	
			System.out.println(resource.getResourceName());
		
			Resource resource2 = new FileSystemResource("src/test/resources/datafile/customerServiceTest.xml");
		//Resource resource2 = new FileSystemResource(getPath(resource.getResourceName(),"datafile"));
		resource = resource2;
		System.out.println(resource2);
		return super.loadData(resource2);
	}
	
	public String getPath(String path,String environment) {
		return String.format(path, environment);
	}

	

	
	

}
