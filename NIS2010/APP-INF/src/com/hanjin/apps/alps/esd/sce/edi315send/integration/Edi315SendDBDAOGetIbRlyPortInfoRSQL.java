/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : Edi315SendDBDAOGetIbRlyPortInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.17
*@LastModifier : 이윤정
*@LastVersion : 1.0
* 2010.02.17 이윤정
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Yoonjung Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetIbRlyPortInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetIbRlyPortInfo
	  * </pre>
	  */
	public Edi315SendDBDAOGetIbRlyPortInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetIbRlyPortInfoRSQL").append("\n"); 
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
		query.append("SELECT  LOC_CD rly_port," ).append("\n"); 
		query.append("LOC_NM rly_name," ).append("\n"); 
		query.append("CNT_CD rly_code," ).append("\n"); 
		query.append("LOC_AMS_PORT_CD rly_amsport," ).append("\n"); 
		query.append("DECODE(CNT_CD, 'US', 'D', 'K') rly_amsqual" ).append("\n"); 
		query.append("FROM    MDM_LOCATION" ).append("\n"); 
		query.append("WHERE   LOC_CD = ( select /*+ index_desc(BKG_vvd XPKBKG_VVD) */" ).append("\n"); 
		query.append("POL_CD" ).append("\n"); 
		query.append("from    BKG_VVD" ).append("\n"); 
		query.append("where   bkg_No       = @[bkg_no]" ).append("\n"); 
		query.append("and rownum = 1" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}