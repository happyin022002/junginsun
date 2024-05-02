/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : JointOperationAccrualCreationDBDAOJooEstmActRsltRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.30
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.06.30 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author jang kang cheol
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class JointOperationAccrualCreationDBDAOJooEstmActRsltRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * DESC Enter..
	  * </pre>
	  */
	public JointOperationAccrualCreationDBDAOJooEstmActRsltRSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rev_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("jo_crr_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rlane_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bsa_slt_prc",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("acct_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("exe_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = "12,N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("estm_vvd_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		query.append("A.EXE_YRMON           ," ).append("\n"); 
		query.append("A.REV_YRMON           ," ).append("\n"); 
		query.append("A.JO_CRR_CD           ," ).append("\n"); 
		query.append("A.RLANE_CD            ," ).append("\n"); 
		query.append("A.VSL_CD              ," ).append("\n"); 
		query.append("A.SKD_VOY_NO          ," ).append("\n"); 
		query.append("A.SKD_DIR_CD          ," ).append("\n"); 
		query.append("A.REV_DIR_CD          ," ).append("\n"); 
		query.append("A.ESTM_VVD_TP_CD      ," ).append("\n"); 
		query.append("A.ACCT_CD             ," ).append("\n"); 
		query.append("A.BSA_QTY             ," ).append("\n"); 
		query.append("A.BSA_SLT_PRC         ," ).append("\n"); 
		query.append("A.ESTM_AMT            ," ).append("\n"); 
		query.append("A.ACT_AMT             ," ).append("\n"); 
		query.append("A.ACCL_AMT            ," ).append("\n"); 
		query.append("A.SYS_SRC_ID          ," ).append("\n"); 
		query.append("A.LOC_CD              ," ).append("\n"); 
		query.append("A.JO_IOC_DIV_CD       ," ).append("\n"); 
		query.append("A.ESTM_VVD_HDR_ID     ," ).append("\n"); 
		query.append("A.JO_CNTR_DIV_CTNT    ," ).append("\n"); 
		query.append("A.CNTR_BLK_DIV_CD     ," ).append("\n"); 
		query.append("A.ACCL_AMT_CORR_FLG   ," ).append("\n"); 
		query.append("A.CRE_DT              ," ).append("\n"); 
		query.append("A.CRE_USR_ID          ," ).append("\n"); 
		query.append("A.UPD_DT              ," ).append("\n"); 
		query.append("A.UPD_USR_ID" ).append("\n"); 
		query.append("FROM  JOO_ESTM_ACT_RSLT A" ).append("\n"); 
		query.append("WHERE  1 = 1" ).append("\n"); 
		query.append("#if (${exe_yrmon} != '')" ).append("\n"); 
		query.append("AND  A.EXE_YRMON = @[exe_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rev_yrmon} != '')" ).append("\n"); 
		query.append("AND  A.REV_YRMON =  @[rev_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${jo_crr_cd} != '')" ).append("\n"); 
		query.append("AND  A.JO_CRR_CD =  @[jo_crr_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${rlane_cd} != '')" ).append("\n"); 
		query.append("AND  A.RLANE_CD =  @[rlane_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${vsl_cd} != '')" ).append("\n"); 
		query.append("AND  A.VSL_CD =  @[vsl_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_voy_no} != '')" ).append("\n"); 
		query.append("AND  A.SKD_VOY_NO =  @[skd_voy_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${skd_dir_cd} != '')" ).append("\n"); 
		query.append("AND  A.SKD_DIR_CD =  @[skd_dir_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${estm_vvd_tp_cd} != '')" ).append("\n"); 
		query.append("AND  A.ESTM_VVD_TP_CD =  @[estm_vvd_tp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${acct_cd} != '')" ).append("\n"); 
		query.append("AND  A.ACCT_CD =  @[acct_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bsa_qty} != '')" ).append("\n"); 
		query.append("AND  A.BSA_QTY =  @[bsa_qty]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bsa_slt_prc} != '')" ).append("\n"); 
		query.append("AND  A.BSA_SLT_PRC =  @[bsa_slt_prc]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.nis2010.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration ").append("\n"); 
		query.append("FileName : JointOperationAccrualCreationDBDAOJooEstmActRsltRSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}