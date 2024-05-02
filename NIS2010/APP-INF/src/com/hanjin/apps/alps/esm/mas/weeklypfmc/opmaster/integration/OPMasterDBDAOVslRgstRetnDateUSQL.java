/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OPMasterDBDAOVslRgstRetnDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.28
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.01.28 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOVslRgstRetnDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * MAS_VSL_RGST Table의 VSL_RETN_FM_DT,VSL_RETN_TO_DT 수정
	  * </pre>
	  */
	public OPMasterDBDAOVslRgstRetnDateUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_retn_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_retn_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.mas.weeklypfmc.opmaster.integration").append("\n"); 
		query.append("FileName : OPMasterDBDAOVslRgstRetnDateUSQL").append("\n"); 
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
		query.append("UPDATE MAS_VSL_RGST SET" ).append("\n"); 
		query.append("VSL_RETN_FM_DT  = TO_DATE(@[vsl_retn_fm_dt],'YYYYMMDD')" ).append("\n"); 
		query.append(", VSL_RETN_TO_DT  = TO_DATE(@[vsl_retn_to_dt],'YYYYMMDD')" ).append("\n"); 
		query.append("WHERE VSL_CD         = @[vsl_cd]" ).append("\n"); 

	}
}