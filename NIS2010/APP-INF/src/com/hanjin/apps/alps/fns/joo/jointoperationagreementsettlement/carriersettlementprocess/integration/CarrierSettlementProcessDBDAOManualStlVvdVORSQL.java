/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CarrierSettlementProcessDBDAOManualStlVvdVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.09.25 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Park Hee Dong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CarrierSettlementProcessDBDAOManualStlVvdVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * FNS_JOO_0053 화면에서 조회될 내용(VVD로 SLIP조회)
	  * </pre>
	  */
	public CarrierSettlementProcessDBDAOManualStlVvdVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration").append("\n"); 
		query.append("FileName : CarrierSettlementProcessDBDAOManualStlVvdVORSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("B.ACCT_YRMON," ).append("\n"); 
		query.append("B.JO_CRR_CD," ).append("\n"); 
		query.append("A.RLANE_CD," ).append("\n"); 
		query.append("A.VSL_CD||A.SKD_VOY_NO||A.SKD_DIR_CD||A.REV_DIR_CD AS VVD," ).append("\n"); 
		query.append("A.CSR_LOCL_AMT," ).append("\n"); 
		query.append("A.SLP_TP_CD||A.SLP_FUNC_CD||A.SLP_OFC_CD||TO_CHAR(TO_DATE(A.SLP_ISS_DT,'YYYYMMDD'),'RRMMDD')||A.SLP_SER_NO AS CSR_NO" ).append("\n"); 
		query.append("FROM   JOO_SLIP    A," ).append("\n"); 
		query.append("JOO_STL_CMB B" ).append("\n"); 
		query.append("WHERE  A.SLP_TP_CD   = B.SLP_TP_CD" ).append("\n"); 
		query.append("AND    A.SLP_FUNC_CD = B.SLP_FUNC_CD" ).append("\n"); 
		query.append("AND    A.SLP_OFC_CD  = B.SLP_OFC_CD" ).append("\n"); 
		query.append("AND    A.SLP_ISS_DT  = B.SLP_ISS_DT" ).append("\n"); 
		query.append("AND    A.SLP_SER_NO  = B.SLP_SER_NO" ).append("\n"); 
		query.append("AND    A.VSL_CD      = @[vsl_cd]" ).append("\n"); 
		query.append("AND    A.SKD_VOY_NO  = @[skd_voy_no]" ).append("\n"); 
		query.append("AND    A.SKD_DIR_CD  = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND    A.REV_DIR_CD  = @[rev_dir_cd]" ).append("\n"); 
		query.append("AND    B.JO_CRR_CD   = @[jo_crr_cd]" ).append("\n"); 
		query.append("AND    A.RLANE_CD    = @[rlane_cd]" ).append("\n"); 
		query.append("AND    B.RE_DIVR_CD  = @[re_divr_cd]" ).append("\n"); 
		query.append("AND    A.DR_CR_CD    = 'DR'" ).append("\n"); 
		query.append("ORDER  BY 1,2" ).append("\n"); 

	}
}