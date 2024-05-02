/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCmdtByRfaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.07.23
*@LastModifier : 
*@LastVersion : 1.0
* 2015.07.23 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchCmdtByRfaRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * rfa 계약 상의 Commodity를 조회한다.
	  * 
	  * 2015.03.12 Actual Customer 추가 (김보영 과장)
	  * 2015.07.23 Actual Customer Code 추가 (김아영 대리)
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchCmdtByRfaRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("prop_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amdt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cmdt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchCmdtByRfaRSQL").append("\n"); 
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
		query.append("SELECT A.PRC_CMDT_DEF_CD" ).append("\n"); 
		query.append("     , A.CMDT_NM" ).append("\n"); 
		query.append("     , A.TYPE" ).append("\n"); 
		query.append("     , A.CMDT_CD" ).append("\n"); 
		query.append("     , A.SVC_SCP_CD" ).append("\n"); 
		query.append("     , A.REP_CMDT_CD" ).append("\n"); 
		query.append("     , ACT.ACT_CUST_NM" ).append("\n"); 
		query.append("     , ACT.CODE" ).append("\n"); 
		query.append(" FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("select prc_cmdt_def_cd, rep_cmdt.rep_cmdt_nm cmdt_nm, 'REP' type, null cmdt_Cd, rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("     , rp_cmdt.cmdt_hdr_seq" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(" where rp_cmdt.prc_cmdt_def_cd = rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'R' --Rep commodity" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_cd    like @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_nm    like @[cmdt_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select prc_cmdt_def_cd, cmdt.cmdt_nm, 'CMDT' type, cmdt_Cd,rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("     , rp_cmdt.cmdt_hdr_seq" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, mdm_commodity cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(" where rp_cmdt.prc_cmdt_def_cd = cmdt.cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'C' --commodity" ).append("\n"); 
		query.append("   and cmdt.rep_cmdt_cd			   = rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and cmdt.cmdt_cd            like @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '') " ).append("\n"); 
		query.append("   and cmdt.cmdt_nm            like @[cmdt_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select grp_cmdt.prc_cmdt_def_cd, rep_cmdt.rep_cmdt_nm cmdt_nm, 'REP' type, null cmdt_Cd,rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("     , rp_cmdt.cmdt_hdr_seq" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, pri_rp_scp_grp_cmdt_dtl grp_cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(" where rp_cmdt.prop_no         = grp_cmdt.prop_no" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_Seq        = grp_cmdt.amdt_seq" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd      = grp_cmdt.svc_scp_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'G' --group commodity" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_tp_cd = 'R' --Rep commodity" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_def_cd= rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_cd    like @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_nm    like @[cmdt_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select grp_cmdt.prc_cmdt_def_cd, cmdt.cmdt_nm, 'CMDT' type, cmdt_Cd,rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("     , rp_cmdt.cmdt_hdr_seq" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, pri_rp_scp_grp_cmdt_dtl grp_cmdt, mdm_commodity cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(" where rp_cmdt.prop_no         = grp_cmdt.prop_no" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_Seq        = grp_cmdt.amdt_seq" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd      = grp_cmdt.svc_scp_cd" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_def_cd= cmdt.cmdt_cd" ).append("\n"); 
		query.append("   and cmdt.rep_cmdt_cd	       = rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'G' --group commodity" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_tp_cd = 'C' --commodity" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and cmdt.cmdt_cd            like @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("   and cmdt.cmdt_nm            like @[cmdt_nm]||'%' " ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append(",(" ).append("\n"); 
		query.append("SELECT PROP_NO" ).append("\n"); 
		query.append("     , AMDT_SEQ" ).append("\n"); 
		query.append("     , SVC_SCP_CD" ).append("\n"); 
		query.append("     , CMDT_HDR_SEQ" ).append("\n"); 
		query.append("     , (SELECT CUST_LGL_ENG_NM" ).append("\n"); 
		query.append("          FROM MDM_CUSTOMER" ).append("\n"); 
		query.append("         WHERE CUST_CNT_CD = A.CUST_CNT_CD" ).append("\n"); 
		query.append("           AND CUST_SEQ = A.CUST_SEQ" ).append("\n"); 
		query.append("           AND ROWNUM = 1) AS ACT_CUST_NM" ).append("\n"); 
		query.append("     , A.CUST_CNT_CD||A.CUST_SEQ AS CODE" ).append("\n"); 
		query.append("     , PRC_PROG_STS_CD" ).append("\n"); 
		query.append("     , SRC_INFO_CD" ).append("\n"); 
		query.append("  FROM PRI_RP_SCP_RT_ACT_CUST A" ).append("\n"); 
		query.append(" WHERE PROP_NO  = @[prop_no]" ).append("\n"); 
		query.append("   AND AMDT_SEQ = @[amdt_seq]" ).append("\n"); 
		query.append("   AND SRC_INFO_CD <> 'AD'" ).append("\n"); 
		query.append(") ACT" ).append("\n"); 
		query.append("WHERE A.SVC_SCP_CD   = ACT.SVC_SCP_CD(+)" ).append("\n"); 
		query.append("AND   A.CMDT_HDR_SEQ = ACT.CMDT_HDR_SEQ(+)" ).append("\n"); 
		query.append("GROUP BY A.PRC_CMDT_DEF_CD, A.CMDT_NM, A.TYPE, A.CMDT_CD, A.SVC_SCP_CD, A.REP_CMDT_CD, ACT.ACT_CUST_NM, ACT.CODE" ).append("\n"); 
		query.append("ORDER BY A.PRC_CMDT_DEF_CD, A.CMDT_NM, A.TYPE, A.CMDT_CD, A.SVC_SCP_CD, A.REP_CMDT_CD, ACT.ACT_CUST_NM, ACT.CODE" ).append("\n"); 

	}
}