/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierRestrictionDBDAOScgImdgCrrRstrVOUSQL.java
*@FileTitle : Estimate Code Check - Carrier
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.07.03 장강철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierRestrictionDBDAOScgImdgCrrRstrVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public CarrierRestrictionDBDAOScgImdgCrrRstrVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_un_no_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_crr_rstr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_crr_rstr_expt_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_opr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("imdg_un_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("slan_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("crr_regu_desc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("imdg_clss_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("UPDATE  SCG_IMDG_CRR_RSTR" ).append("\n"); 
		query.append("SET	VSL_OPR_TP_CD         =  @[vsl_opr_tp_cd]," ).append("\n"); 
		query.append("IMDG_CRR_RSTR_SEQ     =  @[imdg_crr_rstr_seq]," ).append("\n"); 
		query.append("IMDG_UN_NO            =  @[imdg_un_no]," ).append("\n"); 
		query.append("IMDG_UN_NO_SEQ        =  @[imdg_un_no_seq]," ).append("\n"); 
		query.append("IMDG_CLSS_CD          =  @[imdg_clss_cd]," ).append("\n"); 
		query.append("IMDG_CRR_RSTR_EXPT_CD =  @[imdg_crr_rstr_expt_cd]," ).append("\n"); 
		query.append("SLAN_CD               =  @[slan_cd]," ).append("\n"); 
		query.append("CRR_REGU_DESC         =  @[crr_regu_desc]," ).append("\n"); 
		query.append("UPD_USR_ID            =  @[upd_usr_id]," ).append("\n"); 
		query.append("UPD_DT                =  SYSDATE" ).append("\n"); 
		query.append("WHERE	VSL_OPR_TP_CD         =  @[vsl_opr_tp_cd]" ).append("\n"); 
		query.append("AND	IMDG_CRR_RSTR_SEQ     =  @[imdg_crr_rstr_seq]" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.vop.scg.dangerouscargorestriction.carrierrestriction.integration").append("\n"); 
		query.append("FileName : CarrierRestrictionDBDAOScgImdgCrrRstrVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}