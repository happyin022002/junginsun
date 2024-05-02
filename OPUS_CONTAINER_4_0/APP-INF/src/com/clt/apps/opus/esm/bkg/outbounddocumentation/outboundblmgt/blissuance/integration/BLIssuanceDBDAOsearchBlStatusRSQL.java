/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : BLIssuanceDBDAOsearchBlStatusRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.28
*@LastModifier : 
*@LastVersion : 1.0
* 2016.05.28 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOsearchBlStatusRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchBlStatus
	  * </pre>
	  */
	public BLIssuanceDBDAOsearchBlStatusRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOsearchBlStatusRSQL").append("\n"); 
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
		query.append("SELECT DECODE(NVL(CHN_AGN_CD, '*'), '*', DECODE(DECODE(RT_BL_TP_CD, 'C', 1, 'B', 1, CHG_IND.CNT), 0, 'N', 'Y'), 'Y') CHG_READY,									" ).append("\n"); 
		query.append("       DECODE(NVL(MK_IND.CNT,0), 0, 'N', 'Y') MK_READY,	" ).append("\n"); 
		query.append("       DECODE(NVL(CNTR.CNT,0),0,'N','Y') CNTR_READY,								" ).append("\n"); 
		query.append("       DECODE(NVL(CHN_AGN_CD, '*'), '*', DECODE(DECODE(CHG_PPD_IND.OBL_RLSE_FLG,'N',0,CHG_PPD_IND.CNT), 0, 'Y', DECODE(CHG_PPD_IND.ORG_PPD_RCV_CD, 'C', 'Y', 'Y', 'Y', 'N')), 'Y')   CHG_PPD_IND,									" ).append("\n"); 
		query.append("       DECODE(NVL(CHN_AGN_CD, '*'), '*',DECODE(DECODE(CHG_PPD_THIRD_IND.OBL_RLSE_FLG,'N',0,CHG_PPD_THIRD_IND.CNT), 0, 'Y', DECODE(CHG_PPD_THIRD_IND.ORG_N3PTY_PPD_CD, 'C', 'Y', 'Y', 'Y', 'N')), 'Y') CHG_PPD_THIRD_IND,									" ).append("\n"); 
		query.append("       DECODE(ISS.OTR_DOC_CGOR_FLG, 'Y', 'Y', DECODE(DO_CHK.CNT, 0, 'Y', 'N')) DO_CHK_IND," ).append("\n"); 
		query.append("       DECODE(NVL(CNEE_IND.CNT,0), 0, 'N', 'Y') CNEE_READY" ).append("\n"); 
		query.append("FROM " ).append("\n"); 
		query.append("BKG_BOOKING BKG ," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT     A.BKG_NO, A.RT_BL_TP_CD, COUNT(B.BKG_NO) CNT" ).append("\n"); 
		query.append("	FROM       BKG_RATE A, " ).append("\n"); 
		query.append("	    BKG_CHG_RT B" ).append("\n"); 
		query.append("	WHERE      A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("	GROUP BY   A.BKG_NO , A.RT_BL_TP_CD " ).append("\n"); 
		query.append(" ) CHG_IND," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT     A.BKG_NO, COUNT(B.BKG_NO) CNT" ).append("\n"); 
		query.append("	FROM       BKG_RATE A, " ).append("\n"); 
		query.append("	    BKG_BL_MK_DESC B" ).append("\n"); 
		query.append("	WHERE      A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("	AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("	AND        B.CMDT_DESC IS NOT NULL" ).append("\n"); 
		query.append("	GROUP BY   A.BKG_NO " ).append("\n"); 
		query.append(" ) MK_IND,		" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT     C.BKG_NO, COUNT(C.BKG_NO) CNT" ).append("\n"); 
		query.append("    FROM       BKG_CONTAINER C" ).append("\n"); 
		query.append("    WHERE      C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("    GROUP BY   C.BKG_NO" ).append("\n"); 
		query.append(" ) CNTR," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT     A.BKG_NO, C.ORG_PPD_RCV_CD, C.OBL_RLSE_FLG, COUNT(B.BKG_NO) CNT		" ).append("\n"); 
		query.append("	 FROM       BKG_BOOKING A, 		" ).append("\n"); 
		query.append("		    BKG_CHG_RT B,		" ).append("\n"); 
		query.append("		    BKG_BL_ISS C		" ).append("\n"); 
		query.append("	 WHERE      A.BKG_NO = @[bkg_no]		" ).append("\n"); 
		query.append("	 AND        A.BKG_NO = B.BKG_NO(+)		" ).append("\n"); 
		query.append("	 AND        A.BKG_NO = C.BKG_NO		 " ).append("\n"); 
		query.append("	 AND        B.FRT_TERM_CD (+) = 'P'		" ).append("\n"); 
		query.append("	 AND        B.N3PTY_RCV_OFC_CD(+) IS NULL		" ).append("\n"); 
		query.append("	 GROUP BY   A.BKG_NO, C.ORG_PPD_RCV_CD ,C.OBL_RLSE_FLG" ).append("\n"); 
		query.append(") CHG_PPD_IND, 		" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT     A.BKG_NO, C.ORG_N3PTY_PPD_CD, C.OBL_RLSE_FLG, COUNT(B.BKG_NO) CNT		" ).append("\n"); 
		query.append("	 FROM       BKG_BOOKING A, 		" ).append("\n"); 
		query.append("		    BKG_CHG_RT B,		" ).append("\n"); 
		query.append("		    BKG_BL_ISS C		" ).append("\n"); 
		query.append("	 WHERE      A.BKG_NO = @[bkg_no]		" ).append("\n"); 
		query.append("	 AND        A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("	 AND        A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("	 AND        B.FRT_TERM_CD (+) = 'P'" ).append("\n"); 
		query.append("	 AND        B.N3PTY_RCV_OFC_CD(+) IS NOT NULL" ).append("\n"); 
		query.append("	 GROUP BY   A.BKG_NO, C.ORG_N3PTY_PPD_CD ,C.OBL_RLSE_FLG" ).append("\n"); 
		query.append(") CHG_PPD_THIRD_IND," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT A.BKG_NO, " ).append("\n"); 
		query.append("	CASE " ).append("\n"); 
		query.append("	WHEN  SUBSTR(A.DEL_CD, 1, 2) != 'US' THEN DO_DTL.CNT" ).append("\n"); 
		query.append("	ELSE  CGO_DTL.CNT" ).append("\n"); 
		query.append("	END   CNT" ).append("\n"); 
		query.append("	FROM  BKG_BOOKING A," ).append("\n"); 
		query.append("	      (" ).append("\n"); 
		query.append("		      SELECT A.BKG_NO BKG_NO, SUBSTR(A.DEL_CD, 1, 2) DEL, COUNT(B.BKG_NO) CNT" ).append("\n"); 
		query.append("		      FROM BKG_BOOKING A, BKG_DO_DTL B" ).append("\n"); 
		query.append("		      WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		      AND A.BKG_NO = B.BKG_NO(+)" ).append("\n"); 
		query.append("		      AND B.RLSE_STS_CD(+) = DECODE(SUBSTR(A.DEL_CD, 1, 2), 'JP', 'D', 'R')" ).append("\n"); 
		query.append("		      GROUP BY A.BKG_NO, SUBSTR(A.DEL_CD, 1, 2)) " ).append("\n"); 
		query.append("		      DO_DTL," ).append("\n"); 
		query.append("		      (SELECT C.BKG_NO BKG_NO, SUBSTR(C.DEL_CD, 1, 2) DEL, COUNT(D.BL_NO) CNT" ).append("\n"); 
		query.append("		      FROM BKG_BOOKING C, BKG_CGO_RLSE D" ).append("\n"); 
		query.append("		      WHERE C.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("		      AND C.BL_NO = D.BL_NO(+)" ).append("\n"); 
		query.append("		      AND D.FRT_CLT_FLG(+) = 'Y'" ).append("\n"); 
		query.append("		      AND D.OBL_RDEM_FLG(+) = 'Y'" ).append("\n"); 
		query.append("		      AND D.CSTMS_CLR_CD(+) = 'Y'" ).append("\n"); 
		query.append("		      GROUP BY C.BKG_NO, SUBSTR(C.DEL_CD, 1, 2)" ).append("\n"); 
		query.append("		) CGO_DTL" ).append("\n"); 
		query.append("	WHERE A.BKG_NO =  DO_DTL.BKG_NO" ).append("\n"); 
		query.append("	AND A.BKG_NO = CGO_DTL.BKG_NO" ).append("\n"); 
		query.append("	AND A.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append(") DO_CHK," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("	SELECT     A.BKG_NO, COUNT(A.CUST_NM) CNT" ).append("\n"); 
		query.append("	FROM       BKG_CUSTOMER A" ).append("\n"); 
		query.append("	WHERE      A.BKG_NO = @[bkg_no] " ).append("\n"); 
		query.append("    AND        BKG_CUST_TP_CD ='C'" ).append("\n"); 
		query.append("    GROUP BY A.BKG_NO" ).append("\n"); 
		query.append(") CNEE_IND," ).append("\n"); 
		query.append("BKG_BL_ISS ISS" ).append("\n"); 
		query.append("WHERE   BKG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CHG_IND.BKG_NO (+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = MK_IND.BKG_NO (+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CHG_PPD_IND.BKG_NO (+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CHG_PPD_THIRD_IND.BKG_NO (+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = DO_CHK.BKG_NO (+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = CNTR.BKG_NO (+)" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = ISS.BKG_NO (+)" ).append("\n"); 

	}
}