/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ContainerMovementMgtDBDAOsearchBookingInfoByBkgNoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.08.10
*@LastModifier : 
*@LastVersion : 1.0
* 2015.08.10 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ContainerMovementMgtDBDAOsearchBookingInfoByBkgNoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 부킹 일반 정보를 얻어온다.
	  * OP/OC에서 사용함
	  * </pre>
	  */
	public ContainerMovementMgtDBDAOsearchBookingInfoByBkgNoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.integration").append("\n"); 
		query.append("FileName : ContainerMovementMgtDBDAOsearchBookingInfoByBkgNoRSQL").append("\n"); 
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
		query.append("SELECT A.SYS_AREA_GRP_ID AS SVR_ID," ).append("\n"); 
		query.append("       NVL (B.BKG_STS_CD, ' ') BKG_STS_CD," ).append("\n"); 
		query.append("       B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	   B.RCV_TERM_CD," ).append("\n"); 
		query.append("	   B.VSL_CD," ).append("\n"); 
		query.append("	   B.SKD_VOY_NO," ).append("\n"); 
		query.append("       B.SKD_DIR_CD," ).append("\n"); 
		query.append("	   B.DCGO_FLG," ).append("\n"); 
		query.append("	   B.RC_FLG," ).append("\n"); 
		query.append("	   B.AWK_CGO_FLG," ).append("\n"); 
		query.append("	   B.BB_CGO_FLG," ).append("\n"); 
		query.append("	   B.RD_CGO_FLG," ).append("\n"); 
		query.append("       B.DE_TERM_CD," ).append("\n"); 
		query.append("	   B.POL_CD," ).append("\n"); 
		query.append("	   B.POD_CD," ).append("\n"); 
		query.append("       DECODE(BKG_DOC_PROC_TP_CD, NULL, 'N', 'Y') BKG_CFM," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       B.MTY_SPLIT_AVAL_CD" ).append("\n"); 
		query.append("  FROM COM_SYS_AREA_GRP_ID A, BKG_BOOKING B, BKG_DOC_PROC_SKD D" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("   AND A.CNT_CD   = SUBSTR(B.POL_CD, 1, 2)" ).append("\n"); 
		query.append("   AND A.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("   AND D.BKG_DOC_PROC_TP_CD(+) = 'CNTCFM'" ).append("\n"); 
		query.append("   AND D.DOC_PERF_DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND B.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT A.SYS_AREA_GRP_ID AS SVR_ID," ).append("\n"); 
		query.append("       NVL (B.BKG_STS_CD, ' ') BKG_STS_CD," ).append("\n"); 
		query.append("       B.BKG_CGO_TP_CD," ).append("\n"); 
		query.append("	   B.RCV_TERM_CD," ).append("\n"); 
		query.append("	   B.VSL_CD," ).append("\n"); 
		query.append("	   B.SKD_VOY_NO," ).append("\n"); 
		query.append("       B.SKD_DIR_CD," ).append("\n"); 
		query.append("	   B.DCGO_FLG," ).append("\n"); 
		query.append("	   B.RC_FLG," ).append("\n"); 
		query.append("	   B.AWK_CGO_FLG," ).append("\n"); 
		query.append("	   B.BB_CGO_FLG," ).append("\n"); 
		query.append("	   B.RD_CGO_FLG," ).append("\n"); 
		query.append("       B.DE_TERM_CD," ).append("\n"); 
		query.append("	   B.POL_CD," ).append("\n"); 
		query.append("	   B.POD_CD," ).append("\n"); 
		query.append("       DECODE(BKG_DOC_PROC_TP_CD, NULL, 'N', 'Y') BKG_CFM," ).append("\n"); 
		query.append("       B.DEL_CD," ).append("\n"); 
		query.append("       B.BKG_NO," ).append("\n"); 
		query.append("       B.BL_NO," ).append("\n"); 
		query.append("       B.MTY_SPLIT_AVAL_CD" ).append("\n"); 
		query.append("  FROM COM_SYS_AREA_GRP_ID A, CTM_BOOKING B, BKG_DOC_PROC_SKD D" ).append("\n"); 
		query.append(" WHERE B.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'X'" ).append("\n"); 
		query.append("   AND NVL (B.BKG_STS_CD, ' ') <> 'S'" ).append("\n"); 
		query.append("   AND A.CNT_CD   = DECODE(B.BKG_STS_CD, 'A', SUBSTR(@[yd_cd], 1, 2), SUBSTR(B.POL_CD, 1, 2))" ).append("\n"); 
		query.append("   AND A.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("   AND D.BKG_DOC_PROC_TP_CD(+) = 'CNTCFM'" ).append("\n"); 
		query.append("   AND D.DOC_PERF_DELT_FLG(+) = 'N'" ).append("\n"); 
		query.append("   AND B.BKG_NO = D.BKG_NO(+)" ).append("\n"); 
		query.append("   AND ROWNUM = 1" ).append("\n"); 

	}
}