<%@ page language="java" contentType="text/html; charset=UTF-8" %> 
<%@ page import="java.io.*, javax.servlet.*, javax.servlet.http.*, org.apache.log4j.Logger" %> 
<%@ page import="com.hanjin.framework.component.message.ErrorHandler" %>
<%
	Logger log = Logger.getLogger(this.getClass().getName());

	String filePath = (String)request.getParameter("filePath")!=null&&!request.getParameter("filePath").trim().equals("")?request.getParameter("filePath"):"";
	String fileName = (String)request.getParameter("fileName")!=null&&!request.getParameter("fileName").trim().equals("")?request.getParameter("fileName"):"";

	log.debug("\n ESD_TRS_0340 filePath:"+filePath+"  / fileName:"+fileName+" \n\n");

	byte[] buf; 
	ServletOutputStream output = null; 

	java.io.FileInputStream fi = null;
	java.io.BufferedInputStream bi = null;
	java.io.File f = null;
	int n = 0;

	try {
		output = response.getOutputStream();

		if ((filePath!=null && !filePath.trim().equals("")) || (fileName!=null && !fileName.trim().equals(""))){
			f = new File(filePath+File.separator+fileName);
			if (f==null || !f.exists()){
				log.debug("\n\n FILE NOT FOUND!!!!!!");
				//log.debug(" @@@ FILE NOT FOUND : " + filePath + File.separator + fileName );
				//throw new FileNotFoundException(" @@@ FILE NOT FOUND : " + filePath + File.separator + fileName );
				%>
				<HTML>										
				<HEAD>                                                                               
				<table width="100%" height="100%" cellpadding="0" border="0">                        
					<tr>                                                                            
						<td valign="center" class="title">                                                    
						<center><b><font color=blue size=20> No file found </font></b></center>         
						</td>                                                                   
					</tr>                                                                           
				</table>                                                                             
				</BODY>                                                                              
				</HTML>                                                                              
				<SCRIPT>                                                                              
					try {                            							                     
						parent.tes_file_not_found_chk();                                             
					} catch(e){}					                                                 
				</SCRIPT>                                                                             
				<%				
			} else {
				response.setContentType("application/pdf");

				fi = new java.io.FileInputStream(f);
				bi = new java.io.BufferedInputStream(fi);

				while ((n = bi.available()) > 0) {
					buf = new byte[n];
					if (bi.read(buf)==-1){
						break;
					}
					output.write(buf);
				}

				output.flush();
				output.close();
			}
		} else {
			log.debug(" @@@ FILE NOT FOUND : " + filePath + fileName);
			//throw new FileNotFoundException(" @@@ FILE NOT FOUND : " + filePath + fileName);
			
			%>
			<HTML>										
			<HEAD>                                                                               
			<table width="100%" height="100%" cellpadding="0" border="0">                        
				<tr>                                                                            
					<td valign="center" class="title">                                                    
					<center><b><font color=blue size=20> No file found </font></b></center>         
					</td>                                                                   
				</tr>                                                                           
			</table>                                                                             
			</BODY>                                                                              
			</HTML>                                                                              
			<SCRIPT>                                                                              
				try {                            							                     
					parent.tes_file_not_found_chk();                                             
				} catch(e){}					                                                 
			</SCRIPT>                                                                             
			<%				
		}

	} catch (FileNotFoundException e) {
		log.debug(e.getMessage());
	} catch (IOException e) { 
		log.debug(e.getMessage());
	} catch (Exception e) {
		log.debug(e.getMessage());
	} finally { 
		try {
			if (fi!=null)fi.close();
			if (bi!=null)bi.close();
			if (output!=null)output.close();
		} catch (IOException e){
			log.debug(e.getMessage());
		} catch (Exception e) {
			log.debug(e.getMessage());
		}
	}
%>
