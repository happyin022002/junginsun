/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchCmdtByRfaRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.10
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2015.12.10 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("svc_scp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
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
		query.append("select prc_cmdt_def_cd, rep_cmdt.rep_cmdt_nm cmdt_nm, 'REP' type, null cmdt_Cd, rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("       ,'' GRP_DESC" ).append("\n"); 
		query.append("       ,'' rfa_desc" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(" where rp_cmdt.prc_cmdt_def_cd = rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'R' --Rep commodity" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_cd    like @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_nm    like '%'|| @[cmdt_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd    =	SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select prc_cmdt_def_cd, cmdt.cmdt_nm, 'CMDT' type, cmdt_Cd,rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("       ,'' GRP_DESC" ).append("\n"); 
		query.append("       ,'' rfa_desc" ).append("\n"); 
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
		query.append("   and cmdt.cmdt_nm            like '%'|| @[cmdt_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd    =	SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union" ).append("\n"); 
		query.append("select grp_cmdt.prc_cmdt_def_cd, rep_cmdt.rep_cmdt_nm cmdt_nm, 'REP' type, null cmdt_Cd,rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("       ,GRP_DESC.PRC_GRP_CMDT_DESC AS grp_desc" ).append("\n"); 
		query.append("       ,rp_cmdt.prc_cmdt_def_cd AS rfa_desc" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, pri_rp_scp_grp_cmdt_dtl grp_cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(",PRI_RP_SCP_GRP_CMDT GRP_DESC" ).append("\n"); 
		query.append(" where rp_cmdt.prop_no         = grp_cmdt.prop_no" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_Seq        = grp_cmdt.amdt_seq" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd      = grp_cmdt.svc_scp_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'G' --group commodity" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_tp_cd = 'R' --Rep commodity" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_def_cd= rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("	AND rp_cmdt.prop_no         = GRP_DESC.prop_no" ).append("\n"); 
		query.append("	and rp_cmdt.amdt_Seq        = GRP_DESC.amdt_seq" ).append("\n"); 
		query.append("	and rp_cmdt.svc_scp_cd      = GRP_DESC.svc_scp_cd" ).append("\n"); 
		query.append("	AND RP_CMDT.prc_cmdt_def_cd = GRP_DESC.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("	and rp_cmdt.cmdt_hdr_seq = grp_cmdt.grp_cmdt_seq" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and rep_cmdt.rep_cmdt_cd    like '%'|| @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("   and (UPPER(rep_cmdt.rep_cmdt_nm)    like '%'|| @[cmdt_nm]||'%' OR UPPER(GRP_DESC.PRC_GRP_CMDT_DESC) like '%'|| @[cmdt_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd    =	SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("union " ).append("\n"); 
		query.append("select grp_cmdt.prc_cmdt_def_cd, cmdt.cmdt_nm, 'CMDT' type, cmdt_Cd,rp_cmdt.svc_scp_cd, rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("       ,GRP_DESC.PRC_GRP_CMDT_DESC AS grp_desc" ).append("\n"); 
		query.append("       ,rp_cmdt.prc_cmdt_def_cd AS rfa_desc" ).append("\n"); 
		query.append("  from pri_rp_scp_rt_cmdt rp_cmdt, pri_rp_scp_grp_cmdt_dtl grp_cmdt, mdm_commodity cmdt, mdm_rep_cmdt rep_cmdt" ).append("\n"); 
		query.append(",PRI_RP_SCP_GRP_CMDT GRP_DESC" ).append("\n"); 
		query.append(" where rp_cmdt.prop_no         = grp_cmdt.prop_no" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_Seq        = grp_cmdt.amdt_seq" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd      = grp_cmdt.svc_scp_cd" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_def_cd= cmdt.cmdt_cd" ).append("\n"); 
		query.append("   and cmdt.rep_cmdt_cd	       = rep_cmdt.rep_cmdt_cd" ).append("\n"); 
		query.append("   and rp_cmdt.prc_cmdt_tp_cd  = 'G' --group commodity" ).append("\n"); 
		query.append("   and grp_cmdt.prc_cmdt_tp_cd = 'C' --commodity" ).append("\n"); 
		query.append("   and rp_cmdt.prop_no         = @[prop_no]" ).append("\n"); 
		query.append("   and rp_cmdt.amdt_seq        = @[amdt_seq]" ).append("\n"); 
		query.append("	AND rp_cmdt.prop_no         = GRP_DESC.prop_no" ).append("\n"); 
		query.append("	and rp_cmdt.amdt_Seq        = GRP_DESC.amdt_seq" ).append("\n"); 
		query.append("	and rp_cmdt.svc_scp_cd      = GRP_DESC.svc_scp_cd" ).append("\n"); 
		query.append("	AND RP_CMDT.prc_cmdt_def_cd = GRP_DESC.PRC_GRP_CMDT_CD" ).append("\n"); 
		query.append("	and rp_cmdt.cmdt_hdr_seq = grp_cmdt.grp_cmdt_seq" ).append("\n"); 
		query.append("#if (${cmdt_cd} != '')" ).append("\n"); 
		query.append("   and cmdt.cmdt_cd            like '%'|| @[cmdt_cd]||'%' --입력했을 때만" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cmdt_nm} != '')" ).append("\n"); 
		query.append("   and (UPPER(cmdt.cmdt_nm)            like '%'|| @[cmdt_nm]||'%' OR UPPER(GRP_DESC.PRC_GRP_CMDT_DESC) like '%'|| @[cmdt_nm]||'%')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${svc_scp_cd} != '')" ).append("\n"); 
		query.append("   and rp_cmdt.svc_scp_cd    =	SUBSTR(@[svc_scp_cd],1,3)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}