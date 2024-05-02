/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : PerformanceReportDBDAOSearchDPCSPfmcErrorListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.11
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.11 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PerformanceReportDBDAOSearchDPCSPfmcErrorListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Performance Report by Error(ESM_BKG_0409)
	  * SR Data의 처리 부문별 담당자의 처리 Error 실적 현황을 조회하는 화면
	  * </pre>
	  */
	public PerformanceReportDBDAOSearchDPCSPfmcErrorListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("amd_respb_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_mt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_grp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("from_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sr_amd_rsn_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pol_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pod_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("to_mt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingreport.performancereport.integration").append("\n"); 
		query.append("FileName : PerformanceReportDBDAOSearchDPCSPfmcErrorListRSQL").append("\n"); 
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
		query.append("SELECT * FROM " ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT  A.USR_GRP_CD" ).append("\n"); 
		query.append(",       (SELECT CD.INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL CD WHERE CD.INTG_CD_ID = 'CD02159' AND CD.INTG_CD_VAL_CTNT = A.USR_GRP_CD) USR_GRP_NM" ).append("\n"); 
		query.append(",       A.AMD_RESPB_USR_ID  --Performance by PIC" ).append("\n"); 
		query.append(",       A.SR_AMD_RSN_TP_CD  --S/R Reason Kind" ).append("\n"); 
		query.append(",		(SELECT CD.INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL CD WHERE CD.INTG_CD_ID ='CD01577' AND CD.INTG_CD_VAL_CTNT = A.SR_AMD_TP_CD) SR_AMD_TP_NM  --S/R Kind" ).append("\n"); 
		query.append(",       (SELECT CD.INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL CD WHERE CD.INTG_CD_ID = 'CD01576' AND CD.INTG_CD_VAL_CTNT = A.SR_AMD_RSN_TP_CD) SR_KIND_NM" ).append("\n"); 
		query.append(",       A.SR_AMD_RSN_CD     --Performance by Queue" ).append("\n"); 
		query.append(",		(SELECT CD.INTG_CD_VAL_DESC FROM COM_INTG_CD_DTL CD WHERE CD.INTG_CD_ID = 'CD01575' AND CD.INTG_CD_VAL_CTNT = A.SR_AMD_RSN_CD ) RSN_NM" ).append("\n"); 
		query.append(",       A.BKG_NO" ).append("\n"); 
		query.append(",       B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD VVD_CD" ).append("\n"); 
		query.append(",       B.POL_CD" ).append("\n"); 
		query.append(",       B.POD_CD" ).append("\n"); 
		query.append(",       A.SR_NO" ).append("\n"); 
		query.append(",       A.SR_AMD_TP_CD" ).append("\n"); 
		query.append(",	    '' FROM_DT" ).append("\n"); 
		query.append(",	    '' FROM_MT" ).append("\n"); 
		query.append(",		'' TO_DT" ).append("\n"); 
		query.append(",		'' TO_MT" ).append("\n"); 
		query.append(",		TO_CHAR(Q.SR_WRK_STS_DT,'YYYY-MM-DD HH24:MI') FNT_OFC_TRNS_DT" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("							#if(${doc_part} !='Y')" ).append("\n"); 
		query.append("								,NVL((SELECT 'Y' FROM" ).append("\n"); 
		query.append("									  BKG_SR_FAX" ).append("\n"); 
		query.append("									  WHERE SR_NO = A.SR_NO" ).append("\n"); 
		query.append("									  AND SR_KND_CD = A.SR_KND_CD" ).append("\n"); 
		query.append("									  AND RCV_OFC_CD IN (" ).append("\n"); 
		query.append("							#if(${doc_part_eu} =='Y')" ).append("\n"); 
		query.append("							'ANRSO','BRESO','DUSSO','FRASO','FXTBO','HAMSC','LONBB','MANBS','MUCSO','RTMSC','FXTSC','HAMRUG'," ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if(${doc_part_jp} =='Y')" ).append("\n"); 
		query.append("							'KIJBA','OSASO','TYOSC'," ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if(${doc_part_sw} =='Y')" ).append("\n"); 
		query.append("							'PENSO','PGUSO','PKGSC','SINSC'," ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							'$$')),'N') DOC_PART" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("							#if(${doc_part} =='Y')" ).append("\n"); 
		query.append("								,'Y' DOC_PART " ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("FROM    BKG_SR_CRNT_RQST Q " ).append("\n"); 
		query.append(",       BKG_SR_AMD_RSN A " ).append("\n"); 
		query.append(",       BKG_BOOKING B" ).append("\n"); 
		query.append("WHERE   Q.BKG_NO            = B.BKG_NO" ).append("\n"); 
		query.append("AND     Q.SR_KND_CD         = A.SR_KND_CD" ).append("\n"); 
		query.append("AND     Q.SR_NO             = A.SR_NO" ).append("\n"); 
		query.append("AND     Q.BKG_NO            = A.BKG_NO" ).append("\n"); 
		query.append("AND     Q.SR_AMD_TP_CD      = A.SR_AMD_TP_CD" ).append("\n"); 
		query.append("AND     Q.SR_AMD_SEQ        = A.SR_AMD_SEQ" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND     Q.SR_WRK_STS_DT  >= to_date(@[from_dt] || @[from_mt], 'YYYY-MM-DD HH24:MI')" ).append("\n"); 
		query.append("AND     Q.SR_WRK_STS_DT  <= to_date(@[to_dt] || @[to_mt], 'YYYY-MM-DD HH24:MI') " ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${vvd_cd} != '')" ).append("\n"); 
		query.append("AND   B.VSL_CD =  SUBSTR(@[vvd_cd],1,4)" ).append("\n"); 
		query.append("AND   B.SKD_VOY_NO = SUBSTR(@[vvd_cd],5,4)" ).append("\n"); 
		query.append("AND   B.SKD_DIR_CD = SUBSTR(@[vvd_cd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${usr_grp_cd} != ''&& ${usr_grp_cd} !='S') " ).append("\n"); 
		query.append("AND     A.USR_GRP_CD       =    @[usr_grp_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${amd_respb_usr_id} != '') " ).append("\n"); 
		query.append("AND     A.AMD_RESPB_USR_ID =    @[amd_respb_usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${sr_amd_rsn_cd} != '') " ).append("\n"); 
		query.append("AND     A.SR_AMD_RSN_CD    =    @[sr_amd_rsn_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pol_cd} != '') " ).append("\n"); 
		query.append("AND     B.POL_CD           =    @[pol_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${pod_cd} != '') " ).append("\n"); 
		query.append("AND     B.POD_CD           =    @[pod_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bkg_no} != '') " ).append("\n"); 
		query.append("AND     Q.BKG_NO           =    @[bkg_no]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") X" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("AND X.DOC_PART ='Y'" ).append("\n"); 

	}
}