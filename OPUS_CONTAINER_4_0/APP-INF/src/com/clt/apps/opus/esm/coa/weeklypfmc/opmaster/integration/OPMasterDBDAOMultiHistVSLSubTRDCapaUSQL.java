/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : OPMasterDBDAOMultiHistVSLSubTRDCapaUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.09
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2010.02.09 이행지
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OPMasterDBDAOMultiHistVSLSubTRDCapaUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Vessel History SubTradeCapa Update
	  * </pre>
	  */
	public OPMasterDBDAOMultiHistVSLSubTRDCapaUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sub_trd_capa",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.coa.weeklypfmc.opmaster.integration ").append("\n"); 
		query.append("FileName : OPMasterDBDAOMultiHistVSLSubTRDCapaUSQL").append("\n"); 
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
		query.append("UPDATE COA_VSL_SUB_TRD_CAPA SET" ).append("\n"); 
		query.append("SUB_TRD_CAPA = @[sub_trd_capa]" ).append("\n"); 
		query.append(",UPD_USR_ID   = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT       = SYSDATE" ).append("\n"); 
		query.append("WHERE VSL_CD     = @[vsl_cd]" ).append("\n"); 
		query.append("AND VSL_SEQ    = @[vsl_seq]" ).append("\n"); 
		query.append("AND SUB_TRD_CD = @[sub_trd_cd]" ).append("\n"); 

	}
}