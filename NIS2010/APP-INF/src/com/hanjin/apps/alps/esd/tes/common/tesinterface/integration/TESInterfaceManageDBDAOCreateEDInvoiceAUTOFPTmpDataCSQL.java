/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : TESInterfaceManageDBDAOCreateEDInvoiceAUTOFPTmpDataCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.25
*@LastModifier : 박재흥
*@LastVersion : 1.0
* 2010.08.25 박재흥
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.common.tesinterface.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author park chae heung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TESInterfaceManageDBDAOCreateEDInvoiceAUTOFPTmpDataCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * CreateEDInvoiceAUTOFPTmpData
	  * </pre>
	  */
	public TESInterfaceManageDBDAOCreateEDInvoiceAUTOFPTmpDataCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.common.tesinterface.integration ").append("\n"); 
		query.append("FileName : TESInterfaceManageDBDAOCreateEDInvoiceAUTOFPTmpDataCSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}

	/**
	 * Query 생성
	 */
	public void setQuery(){
		query.append("insert into TES_EDI_SO_AUTO_FREE_POOL" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#if (${colum_name} != '')" ).append("\n"); 
		query.append("#foreach($colum_name_num IN ${colum_name})" ).append("\n"); 
		query.append("#if($velocityCount < $colum_name.size())" ).append("\n"); 
		query.append("$colum_name_num," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("$colum_name_num" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("values" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("#if (${colum_value} != '')" ).append("\n"); 
		query.append("#foreach($colum_value_num IN ${colum_value})" ).append("\n"); 
		query.append("#if($velocityCount < $colum_value.size())" ).append("\n"); 
		query.append("$colum_value_num," ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("$colum_value_num" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}