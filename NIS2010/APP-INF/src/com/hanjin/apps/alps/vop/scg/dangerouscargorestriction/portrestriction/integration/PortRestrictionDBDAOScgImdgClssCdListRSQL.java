/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PortRestrictionDBDAOScgImdgClssCdListRSQL.java
*@FileTitle : DG Restriction by Port (Inquiry)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.08
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.08 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PortRestrictionDBDAOScgImdgClssCdListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public PortRestrictionDBDAOScgImdgClssCdListRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("class_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("SELECT IMDG_CLSS_CD, IMDG_CLSS_CD_DESC" ).append("\n"); 
		query.append("FROM SCG_IMDG_CLSS_CD" ).append("\n"); 
		query.append("#if (${class_cd} != '' )" ).append("\n"); 
		query.append("WHERE  IMDG_CLSS_CD = @[class_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("WHERE" ).append("\n"); 
		query.append("DELT_FLG = 'N'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY imdg_clss_cd" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.integration").append("\n"); 
		query.append("FileName : PortRestrictionDBDAOScgImdgClssCdListRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}