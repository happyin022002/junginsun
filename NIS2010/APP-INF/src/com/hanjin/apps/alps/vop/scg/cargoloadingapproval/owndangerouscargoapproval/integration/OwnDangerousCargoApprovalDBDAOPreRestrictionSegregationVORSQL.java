/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOPreRestrictionSegregationVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.04.25
*@LastModifier : 원종규
*@LastVersion : 1.0
* 2013.04.25 원종규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jongkyu Weon
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOPreRestrictionSegregationVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Pre Checking Report 화면의 Segregation Validation 목록을 가져온다.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOPreRestrictionSegregationVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOPreRestrictionSegregationVORSQL").append("\n"); 
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
		query.append("##------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("##설명" ).append("\n"); 
		query.append("##1. UN_NO_TBL          : 컨테이너별 Un No. 의 임시 테이블을 생성한다." ).append("\n"); 
		query.append("##2. UN_NO_SEGR_TBL     : 1번에 대하여 Limited/Excepted Qty 예외가 아닌 Un No. 별 Segration 목록을 임시 테이블로 생성한다." ).append("\n"); 
		query.append("##3. UN_NO_SEGR_GRP_TBL : 1번에 대하여 Limited/Excepted Qty 예외가 아닌 Group 별 Segration 목록을 임시 테이블로 생성한다." ).append("\n"); 
		query.append("##4. CLSS1_SEGR_TBL     : Class1 에 대한 Segration 목록을 임시 테이블로 생성한다." ).append("\n"); 
		query.append("##5. SEGR_GRP_NOS_TBL   : Un No. 에 대한 Segration Group Number 목록을 임시 테이블로 생성한다." ).append("\n"); 
		query.append("##6. <Main Query>       : (1) + (2) + (3) + (4)" ).append("\n"); 
		query.append("##                        (1)2번을 기준으로 한 1번과의 Class 비교 Segration 에서 Class1 기준을 상위 적용한 목록을 생성한다. " ).append("\n"); 
		query.append("##                           단, Special Provisions for Segregation에 속한 UN끼리의 혼적은 가능하도록 허용한다." ).append("\n"); 
		query.append("##                        (2)3번을 기준으로 한 1번과의 Croup 비교 Segration 목록을 생성한다." ).append("\n"); 
		query.append("##                           단, Special Provisions for Segregation에 속한 UN끼리의 혼적은 가능하도록 허용한다." ).append("\n"); 
		query.append("##                        (3)1번에서 Un No. Holding 되고 있는 목록을 생성한다." ).append("\n"); 
		query.append("##                        (4)1번에서 Limited/Excepted Qty에 대한 예외처리된 목록을 생성한다." ).append("\n"); 
		query.append("##7. <Note>             : 위의 Query를  Container 갯수만큼 수행하여 출력한다." ).append("\n"); 
		query.append("##------------------------------------------------------------------------------------" ).append("\n"); 
		query.append("WITH UN_NO_TBL AS (" ).append("\n"); 
		query.append("     SELECT T.SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("          , T.SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          , T.IMDG_UN_NO" ).append("\n"); 
		query.append("          , T.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          , DECODE(NVL(UN.SEGR_AS_FOR_IMDG_CLSS_CD,''),'',T.IMDG_CLSS_CD,UN.SEGR_AS_FOR_IMDG_CLSS_CD) IMDG_CLSS_CD" ).append("\n"); 
		query.append("		  ,	NVL(UN.IMDG_UN_NO_HLD_FLG,'N') IMDG_UN_NO_HLD_FLG" ).append("\n"); 
		query.append("          , UN.IMDG_COMP_GRP_CD   " ).append("\n"); 
		query.append("          , CASE WHEN T.LQ_CHK = 'Y' THEN" ).append("\n"); 
		query.append("                                          CASE WHEN NVL(UN.IMDG_LMT_QTY,0) = 0 THEN 'LY'" ).append("\n"); 
		query.append("                                               ELSE 'LX'" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("                 WHEN T.EQ_CHK = 'Y' THEN" ).append("\n"); 
		query.append("                                          CASE WHEN NVL(UN.IMDG_EXPT_QTY_CD,'E0') = 'E0' THEN 'EY'" ).append("\n"); 
		query.append("                                               ELSE 'LX'" ).append("\n"); 
		query.append("                                          END" ).append("\n"); 
		query.append("                 ELSE 'N'" ).append("\n"); 
		query.append("            END AS LEQ_CHK   " ).append("\n"); 
		query.append("          , UN.IMDG_TBL_NO    " ).append("\n"); 
		query.append("       FROM (" ).append("\n"); 
		query.append("#foreach(${obj} in ${opt_obj})" ).append("\n"); 
		query.append("     #if($velocityCount > ${start_num} && $velocityCount <= ${end_num})" ).append("\n"); 
		query.append("             SELECT '$obj.getSpclCntrSeq()'    AS SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("                  , '$obj.getSpclCgoSeq()'     AS SPCL_CGO_SEQ" ).append("\n"); 
		query.append("                  , '$obj.getImdgUnNo()'       AS IMDG_UN_NO" ).append("\n"); 
		query.append("                  , '$obj.getImdgUnNoSeq()'    AS IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("                  , '$obj.getImdgClssCd()'     AS IMDG_CLSS_CD" ).append("\n"); 
		query.append("                  , '$obj.getImdgLmtQtyFlg()'  AS LQ_CHK" ).append("\n"); 
		query.append("                  , '$obj.getImdgExptQtyFlg()' AS EQ_CHK" ).append("\n"); 
		query.append("               FROM DUAL" ).append("\n"); 
		query.append("          #if($velocityCount < ${end_num} && $velocityCount < ${obj_size})" ).append("\n"); 
		query.append("             UNION ALL" ).append("\n"); 
		query.append("          #end" ).append("\n"); 
		query.append("     #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("           ) T, SCG_IMDG_UN_NO UN" ).append("\n"); 
		query.append("      WHERE T.IMDG_UN_NO     = UN.IMDG_UN_NO" ).append("\n"); 
		query.append("        AND T.IMDG_UN_NO_SEQ = UN.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("UN_NO_SEGR_TBL AS (" ).append("\n"); 
		query.append("     SELECT B.SPCL_CNTR_SEQ                     AS SPCL_CNTR_SEQ" ).append("\n"); 
		query.append("          , B.SPCL_CGO_SEQ                      AS SPCL_CGO_SEQ" ).append("\n"); 
		query.append("          , B.IMDG_UN_NO                        AS IMDG_UN_NO" ).append("\n"); 
		query.append("          , B.IMDG_UN_NO_SEQ                    AS IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          , B.IMDG_CLSS_CD                      AS IMDG_CLSS_CD1" ).append("\n"); 
		query.append("          , C.IMDG_CLSS_CD                      AS IMDG_CLSS_CD2" ).append("\n"); 
		query.append("          , B.IMDG_UN_NO_HLD_FLG                AS IMDG_UN_NO_HLD_FLG" ).append("\n"); 
		query.append("          , B.IMDG_COMP_GRP_CD                  AS IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("          , (D.IMDG_SEGR_TP_CD||C.IMDG_SEGR_CD) AS IMDG_SEGR_CD" ).append("\n"); 
		query.append("          , D.IMDG_SEGR_DESC                    AS IMDG_SEGR_DESC" ).append("\n"); 
		query.append("          , B.IMDG_TBL_NO                       AS IMDG_TBL_NO" ).append("\n"); 
		query.append("       FROM UN_NO_TBL           B" ).append("\n"); 
		query.append("          , SCG_IMDG_UN_NO_SEGR C" ).append("\n"); 
		query.append("          , SCG_IMDG_SEGR_SYM   D" ).append("\n"); 
		query.append("      WHERE B.IMDG_UN_NO_HLD_FLG = 'N'" ).append("\n"); 
		query.append("        AND B.LEQ_CHK            = 'N'" ).append("\n"); 
		query.append("        AND B.IMDG_UN_NO         = C.IMDG_UN_NO" ).append("\n"); 
		query.append("        AND B.IMDG_UN_NO_SEQ     = C.IMDG_UN_NO_SEQ     " ).append("\n"); 
		query.append("        AND C.IMDG_SEGR_CD       = D.IMDG_SEGR_CD" ).append("\n"); 
		query.append("        AND NVL(D.DELT_FLG,'N')  = 'N' " ).append("\n"); 
		query.append("        AND D.IMDG_SEGR_TP_CD    = 'C'       " ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("UN_NO_SEGR_GRP_TBL AS (" ).append("\n"); 
		query.append("     SELECT E.SPCL_CNTR_SEQ  " ).append("\n"); 
		query.append("          , E.SPCL_CGO_SEQ   " ).append("\n"); 
		query.append("          , E.IMDG_UN_NO" ).append("\n"); 
		query.append("          , E.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("          , E.IMDG_CLSS_CD" ).append("\n"); 
		query.append("          , E.IMDG_UN_NO_HLD_FLG" ).append("\n"); 
		query.append("          , F.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("          , ('G'||F.IMDG_SEGR_GRP_STWG_TP_CD) AS IMDG_SEGR_GRP_STWG_TP_CD" ).append("\n"); 
		query.append("          , E.IMDG_TBL_NO" ).append("\n"); 
		query.append("       FROM UN_NO_TBL               E" ).append("\n"); 
		query.append("          , SCG_IMDG_UN_NO_SEGR_GRP F" ).append("\n"); 
		query.append("      WHERE E.IMDG_UN_NO_HLD_FLG = 'N'" ).append("\n"); 
		query.append("        AND E.LEQ_CHK            = 'N'" ).append("\n"); 
		query.append("        AND E.IMDG_UN_NO         = F.IMDG_UN_NO" ).append("\n"); 
		query.append("        AND E.IMDG_UN_NO_SEQ     = F.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("CLSS1_SEGR_TBL AS (" ).append("\n"); 
		query.append("     SELECT CGS.ROW_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("          , CGS.COL_IMDG_COMP_GRP_CD" ).append("\n"); 
		query.append("          , ('P'||CGS.IMDG_SEGR_CD) AS IMDG_SEGR_CD" ).append("\n"); 
		query.append("          , CGS.IMDG_SEGR_NTC_NO " ).append("\n"); 
		query.append("          , (SELECT MSG.ERR_MSG FROM COM_ERR_MSG MSG WHERE MSG.ERR_MSG_CD = 'SCG00005') IMDG_SEGR_DESC" ).append("\n"); 
		query.append("       FROM SCG_IMDG_COMP_GRP_SEGR CGS " ).append("\n"); 
		query.append("      WHERE NOT EXISTS (" ).append("\n"); 
		query.append("            SELECT 'X'" ).append("\n"); 
		query.append("              FROM SCG_IMDG_SEGR_SYM SYM" ).append("\n"); 
		query.append("             WHERE SYM.IMDG_SEGR_CD      = CGS.IMDG_SEGR_NTC_NO" ).append("\n"); 
		query.append("               AND NVL(SYM.DELT_FLG,'N') = 'N'" ).append("\n"); 
		query.append("               AND SYM.IMDG_SEGR_TP_CD   = 'P'" ).append("\n"); 
		query.append("      ) " ).append("\n"); 
		query.append(")," ).append("\n"); 
		query.append("SEGR_GRP_NOS_TBL AS (" ).append("\n"); 
		query.append("     SELECT SG.IMDG_UN_NO" ).append("\n"); 
		query.append("          , SUBSTR(XMLAGG(XMLELEMENT(X, '/' || IMDG_SEGR_GRP_NO) ORDER BY IMDG_SEGR_GRP_NO).EXTRACT('//text()'), 2) IMDG_SEGR_GRP_NOS" ).append("\n"); 
		query.append("       FROM SCG_IMDG_SEGR_GRP_DTL SG" ).append("\n"); 
		query.append("      WHERE EXISTS (" ).append("\n"); 
		query.append("                   SELECT 'Y'" ).append("\n"); 
		query.append("                     FROM UN_NO_TBL G" ).append("\n"); 
		query.append("                    WHERE G.IMDG_UN_NO = SG.IMDG_UN_NO" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("         OR EXISTS (" ).append("\n"); 
		query.append("                   SELECT 'Y'" ).append("\n"); 
		query.append("                     FROM UN_NO_SEGR_GRP_TBL H" ).append("\n"); 
		query.append("                    WHERE H.IMDG_UN_NO = SG.IMDG_UN_NO" ).append("\n"); 
		query.append("                   )" ).append("\n"); 
		query.append("      GROUP BY SG.IMDG_UN_NO" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT T.SPCL_CNTR_SEQ1" ).append("\n"); 
		query.append("     , T.SPCL_CGO_SEQ1" ).append("\n"); 
		query.append("     , T.IMDG_UN_NO1" ).append("\n"); 
		query.append("     , T.IMDG_UN_NO_SEQ1" ).append("\n"); 
		query.append("     , T.IMDG_SEGR_GRP_NO1" ).append("\n"); 
		query.append("     , T.CONFLICT_DESC" ).append("\n"); 
		query.append("     , T.SPCL_CNTR_SEQ2" ).append("\n"); 
		query.append("     , T.SPCL_CGO_SEQ2" ).append("\n"); 
		query.append("     , T.IMDG_UN_NO2" ).append("\n"); 
		query.append("     , T.IMDG_UN_NO_SEQ2" ).append("\n"); 
		query.append("     , T.IMDG_SEGR_GRP_NO2" ).append("\n"); 
		query.append("  FROM " ).append("\n"); 
		query.append("  (" ).append("\n"); 
		query.append("    SELECT TST.SPCL_CNTR_SEQ1" ).append("\n"); 
		query.append("         , TST.SPCL_CGO_SEQ1" ).append("\n"); 
		query.append("         , TST.IMDG_UN_NO1" ).append("\n"); 
		query.append("         , TST.IMDG_UN_NO_SEQ1" ).append("\n"); 
		query.append("         , '' AS IMDG_SEGR_GRP_NO1" ).append("\n"); 
		query.append("         , TST.IMDG_UN_NO_HLD_FLG1" ).append("\n"); 
		query.append("         , DECODE(TST.IMDG_SEGR_CD,'C*',CL1.IMDG_SEGR_CD,TST.IMDG_SEGR_CD)    AS IMDG_SEGR_CD" ).append("\n"); 
		query.append("         , DECODE(TST.IMDG_SEGR_CD,'C*',CL1.IMDG_SEGR_DESC,TST.CONFLICT_DESC) AS CONFLICT_DESC" ).append("\n"); 
		query.append("         , TST.SPCL_CNTR_SEQ2" ).append("\n"); 
		query.append("         , TST.SPCL_CGO_SEQ2" ).append("\n"); 
		query.append("         , TST.IMDG_UN_NO2" ).append("\n"); 
		query.append("         , TST.IMDG_UN_NO_SEQ2" ).append("\n"); 
		query.append("         , '' AS IMDG_SEGR_GRP_NO2" ).append("\n"); 
		query.append("         , TST.IMDG_UN_NO_HLD_FLG2" ).append("\n"); 
		query.append("      FROM " ).append("\n"); 
		query.append("         (" ).append("\n"); 
		query.append("          SELECT UNS.SPCL_CNTR_SEQ      AS SPCL_CNTR_SEQ1                       " ).append("\n"); 
		query.append("               , UNS.SPCL_CGO_SEQ       AS SPCL_CGO_SEQ1                      " ).append("\n"); 
		query.append("               , UNS.IMDG_UN_NO         AS IMDG_UN_NO1" ).append("\n"); 
		query.append("               , UNS.IMDG_UN_NO_SEQ     AS IMDG_UN_NO_SEQ1" ).append("\n"); 
		query.append("               , UNS.IMDG_COMP_GRP_CD   AS IMDG_SEGR_GRP_NO1" ).append("\n"); 
		query.append("               , UNS.IMDG_UN_NO_HLD_FLG AS IMDG_UN_NO_HLD_FLG1" ).append("\n"); 
		query.append("               , UNS.IMDG_SEGR_CD       AS IMDG_SEGR_CD" ).append("\n"); 
		query.append("               , UNS.IMDG_SEGR_DESC     AS CONFLICT_DESC" ).append("\n"); 
		query.append("               , UNT.SPCL_CNTR_SEQ      AS SPCL_CNTR_SEQ2                      " ).append("\n"); 
		query.append("               , UNT.SPCL_CGO_SEQ       AS SPCL_CGO_SEQ2                  " ).append("\n"); 
		query.append("               , UNT.IMDG_UN_NO         AS IMDG_UN_NO2" ).append("\n"); 
		query.append("               , UNT.IMDG_UN_NO_SEQ     AS IMDG_UN_NO_SEQ2" ).append("\n"); 
		query.append("               , UNT.IMDG_COMP_GRP_CD   AS IMDG_SEGR_GRP_NO2" ).append("\n"); 
		query.append("               , UNT.IMDG_UN_NO_HLD_FLG AS IMDG_UN_NO_HLD_FLG2" ).append("\n"); 
		query.append("            FROM UN_NO_SEGR_TBL UNS" ).append("\n"); 
		query.append("               , UN_NO_TBL      UNT" ).append("\n"); 
		query.append("           WHERE UNS.IMDG_CLSS_CD2      = UNT.IMDG_CLSS_CD" ).append("\n"); 
		query.append("             AND UNT.IMDG_UN_NO_HLD_FLG = 'N'" ).append("\n"); 
		query.append("             AND UNT.LEQ_CHK            = 'N'" ).append("\n"); 
		query.append("             AND (" ).append("\n"); 
		query.append("                 UNS.IMDG_UN_NO     <> UNT.IMDG_UN_NO" ).append("\n"); 
		query.append("              OR UNS.IMDG_UN_NO_SEQ <> UNT.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("              OR UNS.IMDG_CLSS_CD1  <> UNT.IMDG_CLSS_CD" ).append("\n"); 
		query.append("             )" ).append("\n"); 
		query.append("             AND ((UNS.IMDG_TBL_NO <> UNT.IMDG_TBL_NO) OR UNS.IMDG_TBL_NO IS NULL)" ).append("\n"); 
		query.append("         ) TST" ).append("\n"); 
		query.append("         , CLSS1_SEGR_TBL CL1" ).append("\n"); 
		query.append("     WHERE TST.IMDG_SEGR_GRP_NO1 = CL1.ROW_IMDG_COMP_GRP_CD(+)" ).append("\n"); 
		query.append("       AND TST.IMDG_SEGR_GRP_NO2 = CL1.COL_IMDG_COMP_GRP_CD(+)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT UGT.SPCL_CNTR_SEQ             AS SPCL_CNTR_SEQ1                 " ).append("\n"); 
		query.append("         , UGT.SPCL_CGO_SEQ              AS SPCL_CGO_SEQ1                 " ).append("\n"); 
		query.append("         , UGT.IMDG_UN_NO                AS IMDG_UN_NO1" ).append("\n"); 
		query.append("         , UGT.IMDG_UN_NO_SEQ            AS IMDG_UN_NO_SEQ1" ).append("\n"); 
		query.append("         , SG1.IMDG_SEGR_GRP_NOS         AS IMDG_SEGR_GRP_NO1 " ).append("\n"); 
		query.append("         , UGT.IMDG_UN_NO_HLD_FLG        AS IMDG_UN_NO_HLD_FLG1" ).append("\n"); 
		query.append("         , UGT.IMDG_SEGR_GRP_STWG_TP_CD  AS IMDG_SEGR_CD" ).append("\n"); 
		query.append("         , DECODE(UGT.IMDG_SEGR_GRP_STWG_TP_CD, 'G1', 'Away from Segregation Group '||UGT.IMDG_SEGR_GRP_NO, 'G2', 'Separated from Segregation Group '||UGT.IMDG_SEGR_GRP_NO, 'N/A') AS CONFLICT_DESC" ).append("\n"); 
		query.append("         , UNT.SPCL_CNTR_SEQ             AS SPCL_CNTR_SEQ2                 " ).append("\n"); 
		query.append("         , UNT.SPCL_CGO_SEQ              AS SPCL_CGO_SEQ2                 " ).append("\n"); 
		query.append("         , UNT.IMDG_UN_NO                AS IMDG_UN_NO2" ).append("\n"); 
		query.append("         , UNT.IMDG_UN_NO_SEQ            AS IMDG_UN_NO_SEQ2" ).append("\n"); 
		query.append("         , SG2.IMDG_SEGR_GRP_NOS         AS IMDG_SEGR_GRP_NO2" ).append("\n"); 
		query.append("         , UNT.IMDG_UN_NO_HLD_FLG        AS IMDG_UN_NO_HLD_FLG2" ).append("\n"); 
		query.append("      FROM UN_NO_SEGR_GRP_TBL    UGT" ).append("\n"); 
		query.append("         , SCG_IMDG_SEGR_GRP_DTL ISG" ).append("\n"); 
		query.append("         , UN_NO_TBL             UNT" ).append("\n"); 
		query.append("         , SEGR_GRP_NOS_TBL      SG1" ).append("\n"); 
		query.append("         , SEGR_GRP_NOS_TBL      SG2" ).append("\n"); 
		query.append("     WHERE UGT.IMDG_SEGR_GRP_NO = ISG.IMDG_SEGR_GRP_NO" ).append("\n"); 
		query.append("       AND ISG.IMDG_UN_NO       = UNT.IMDG_UN_NO" ).append("\n"); 
		query.append("       AND UNT.IMDG_UN_NO_HLD_FLG = 'N'" ).append("\n"); 
		query.append("       AND UNT.LEQ_CHK            = 'N'" ).append("\n"); 
		query.append("       AND (" ).append("\n"); 
		query.append("           UGT.IMDG_UN_NO      <> UNT.IMDG_UN_NO" ).append("\n"); 
		query.append("        OR UGT.IMDG_UN_NO_SEQ  <> UNT.IMDG_UN_NO_SEQ" ).append("\n"); 
		query.append("        OR UGT.IMDG_CLSS_CD    <> UNT.IMDG_CLSS_CD" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("       AND ((UGT.IMDG_TBL_NO <> UNT.IMDG_TBL_NO) OR UGT.IMDG_TBL_NO IS NULL)" ).append("\n"); 
		query.append("       AND UGT.IMDG_UN_NO       = SG1.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("       AND UNT.IMDG_UN_NO       = SG2.IMDG_UN_NO(+)" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT UNT.SPCL_CNTR_SEQ             AS SPCL_CNTR_SEQ1                 " ).append("\n"); 
		query.append("         , UNT.SPCL_CGO_SEQ              AS SPCL_CGO_SEQ1                 " ).append("\n"); 
		query.append("         , UNT.IMDG_UN_NO                AS IMDG_UN_NO1" ).append("\n"); 
		query.append("         , UNT.IMDG_UN_NO_SEQ            AS IMDG_UN_NO_SEQ1" ).append("\n"); 
		query.append("         , ''                            AS IMDG_SEGR_GRP_NO1 " ).append("\n"); 
		query.append("         , UNT.IMDG_UN_NO_HLD_FLG        AS IMDG_UN_NO_HLD_FLG1" ).append("\n"); 
		query.append("         , 'HD'                          AS IMDG_SEGR_CD" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("           SELECT MSG.ERR_MSG" ).append("\n"); 
		query.append("             FROM COM_ERR_MSG MSG" ).append("\n"); 
		query.append("            WHERE MSG.ERR_MSG_CD = 'SCG00004'" ).append("\n"); 
		query.append("              AND MSG.LANG_TP_CD = 'ENG'" ).append("\n"); 
		query.append("           )                             AS CONFLICT_DESC" ).append("\n"); 
		query.append("         , ''                            AS SPCL_CNTR_SEQ2                 " ).append("\n"); 
		query.append("         , ''                            AS SPCL_CGO_SEQ2                 " ).append("\n"); 
		query.append("         , ''                            AS IMDG_UN_NO2" ).append("\n"); 
		query.append("         , ''                            AS IMDG_UN_NO_SEQ2" ).append("\n"); 
		query.append("         , ''                            AS IMDG_SEGR_GRP_NO2" ).append("\n"); 
		query.append("         , ''                            AS IMDG_UN_NO_HLD_FLG2" ).append("\n"); 
		query.append("      FROM UN_NO_TBL             UNT" ).append("\n"); 
		query.append("     WHERE UNT.IMDG_UN_NO_HLD_FLG = 'Y'" ).append("\n"); 
		query.append("    UNION ALL" ).append("\n"); 
		query.append("    SELECT UNT.SPCL_CNTR_SEQ             AS SPCL_CNTR_SEQ1                 " ).append("\n"); 
		query.append("         , UNT.SPCL_CGO_SEQ              AS SPCL_CGO_SEQ1                 " ).append("\n"); 
		query.append("         , UNT.IMDG_UN_NO                AS IMDG_UN_NO1" ).append("\n"); 
		query.append("         , UNT.IMDG_UN_NO_SEQ            AS IMDG_UN_NO_SEQ1" ).append("\n"); 
		query.append("         , ''                            AS IMDG_SEGR_GRP_NO1 " ).append("\n"); 
		query.append("         , UNT.IMDG_UN_NO_HLD_FLG        AS IMDG_UN_NO_HLD_FLG1" ).append("\n"); 
		query.append("         , 'CK'                          AS IMDG_SEGR_CD" ).append("\n"); 
		query.append("         , (" ).append("\n"); 
		query.append("           SELECT MSG.ERR_MSG" ).append("\n"); 
		query.append("             FROM COM_ERR_MSG MSG" ).append("\n"); 
		query.append("            WHERE MSG.ERR_MSG_CD = DECODE(UNT.LEQ_CHK,'LY','SCG50016','EY','SCG50019','SCG50016')" ).append("\n"); 
		query.append("              AND MSG.LANG_TP_CD = 'ENG'" ).append("\n"); 
		query.append("           )                             AS CONFLICT_DESC" ).append("\n"); 
		query.append("         , ''                            AS SPCL_CNTR_SEQ2                 " ).append("\n"); 
		query.append("         , ''                            AS SPCL_CGO_SEQ2" ).append("\n"); 
		query.append("         , ''                            AS IMDG_UN_NO2" ).append("\n"); 
		query.append("         , ''                            AS IMDG_UN_NO_SEQ2" ).append("\n"); 
		query.append("         , ''                            AS IMDG_SEGR_GRP_NO2" ).append("\n"); 
		query.append("         , ''                            AS IMDG_UN_NO_HLD_FLG2" ).append("\n"); 
		query.append("      FROM UN_NO_TBL             UNT" ).append("\n"); 
		query.append("     WHERE UNT.LEQ_CHK = 'LY' OR UNT.LEQ_CHK = 'EY'" ).append("\n"); 
		query.append("  ) T" ).append("\n"); 
		query.append("  WHERE NVL(T.IMDG_SEGR_CD,'PX') != 'PX' " ).append("\n"); 
		query.append("    AND T.IMDG_SEGR_CD != 'CX'" ).append("\n"); 
		query.append(" ORDER BY" ).append("\n"); 
		query.append("      TO_NUMBER(T.SPCL_CNTR_SEQ1)" ).append("\n"); 
		query.append("    , TO_NUMBER(T.SPCL_CGO_SEQ1)" ).append("\n"); 
		query.append("    , T.IMDG_UN_NO1" ).append("\n"); 
		query.append("    , T.IMDG_UN_NO_SEQ1" ).append("\n"); 
		query.append("    , T.IMDG_SEGR_GRP_NO1" ).append("\n"); 

	}
}