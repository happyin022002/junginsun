/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OPMasterDBDAOMultiHistVSLInfoChangeDateOfFormerSequenceUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.03.16
*@LastModifier : 
*@LastVersion : 1.0
* 2016.03.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOMultiHistVSLInfoChangeDateOfFormerSequenceUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 2016.03.03 Create Lane Table, Create Vessel Table history 자동 관리
	  * </pre>
	  */
	public OPMasterDBDAOMultiHistVSLInfoChangeDateOfFormerSequenceUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiHistVSLInfoChangeDateOfFormerSequenceUSQL").append("\n"); 
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
		query.append("update MAS_VSL_RGST" ).append("\n"); 
		query.append("set VSL_APLY_TO_DT = SYSDATE - 1" ).append("\n"); 
		query.append("where VSL_CD = @[vsl_cd]" ).append("\n"); 
		query.append("#if (${update_flg} == 'Y')" ).append("\n"); 
		query.append("and VSL_SEQ = (SELECT MAX(VSL_SEQ)" ).append("\n"); 
		query.append("                FROM MAS_VSL_RGST" ).append("\n"); 
		query.append("                WHERE VSL_CD = @[vsl_cd]) - 1" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("and VSL_SEQ = (SELECT MAX(VSL_SEQ)" ).append("\n"); 
		query.append("                FROM MAS_VSL_RGST" ).append("\n"); 
		query.append("                WHERE VSL_CD = @[vsl_cd])" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}