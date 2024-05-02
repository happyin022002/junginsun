/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : EQFlagMgtDBDAOmodifyEqStsMkrNmMdlNmDataUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.12.09
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2010.12.09 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Myoung Sin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EQFlagMgtDBDAOmodifyEqStsMkrNmMdlNmDataUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modifyEqStsMkrNmMdlNmData
	  * </pre>
	  */
	public EQFlagMgtDBDAOmodifyEqStsMkrNmMdlNmDataUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mdl_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("disp_yd_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rpr_cost_amt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mkr_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eq_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.integration").append("\n"); 
		query.append("FileName : EQFlagMgtDBDAOmodifyEqStsMkrNmMdlNmDataUSQL").append("\n"); 
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
		query.append("UPDATE MNR_EQ_STS A" ).append("\n"); 
		query.append("SET A.EQ_MKR_NM = @[mkr_nm]" ).append("\n"); 
		query.append(",A.EQ_MDL_NM = @[mdl_nm]" ).append("\n"); 
		query.append(",A.RPR_COST_AMT = @[rpr_cost_amt]" ).append("\n"); 
		query.append(",A.UPD_USR_ID = @[upd_usr_id]" ).append("\n"); 
		query.append(",A.MNR_DISP_SEL_FLG_YD_CD = @[disp_yd_cd]" ).append("\n"); 
		query.append(",A.UPD_DT = sysdate" ).append("\n"); 
		query.append("WHERE A.EQ_NO = @[eq_no]" ).append("\n"); 

	}
}