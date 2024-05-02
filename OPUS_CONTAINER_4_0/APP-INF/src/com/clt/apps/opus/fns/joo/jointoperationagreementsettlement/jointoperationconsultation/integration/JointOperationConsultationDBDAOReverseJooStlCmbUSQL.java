/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationConsultationDBDAOReverseJooStlCmbUSQL.java
*@FileTitle : CSR Invoice Interface Status
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.17
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.12.17 박희동
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationConsultationDBDAOReverseJooStlCmbUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Reverse전표 생성시 기존 JOO_STL_CMB.RVS_CMB_FLG = 'Y'로 update한다.
	  * </pre>
	  */
	public JointOperationConsultationDBDAOReverseJooStlCmbUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rvs_cmb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("re_divr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("rjct_cmb_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("stl_cmb_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationconsultation.integration").append("\n"); 
		query.append("FileName : JointOperationConsultationDBDAOReverseJooStlCmbUSQL").append("\n"); 
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
		query.append("UPDATE JOO_STL_CMB SET" ).append("\n"); 
		query.append("RVS_CMB_FLG = NVL(@[rvs_cmb_flg],'N')" ).append("\n"); 
		query.append(",RJCT_CMB_FLG= NVL(@[rjct_cmb_flg],'N')" ).append("\n"); 
		query.append(",UPD_USR_ID  = @[upd_usr_id]" ).append("\n"); 
		query.append(",UPD_DT      = SYSDATE" ).append("\n"); 
		query.append("WHERE  ACCT_YRMON  = REPLACE(@[acct_yrmon],'-','')" ).append("\n"); 
		query.append("AND    JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    STL_CMB_SEQ = TO_NUMBER(@[stl_cmb_seq])" ).append("\n"); 
		query.append("AND    RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 

	}
}