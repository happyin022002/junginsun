/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2017.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestList
	  * -. BOOKING에서 INTERFACE된 데이터 중 KEYWORD I +D/G 인 것은 화면에 조회되고 
	  *    USER가 UNDECLARED/PASS/HOLD를 선택할 수 있음.
	  * -. 조회시 USER가 UNDECLARED/HOLD를 지정한 것 중 D/G CARGO여도 보여주도록 함.
	  *    왜냐면, USER가 HOLD라고 해놨는데, BOOKING에서 D/G로 바꿔버리면 조회에서
	  *    안보이기때문에.기본적으로 BKG의 D/G이면 안보이도록 했기때문에
	  * - COMMON NAME이 조회되도록 수정함.
	  * </pre>
	  */
	public OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_fr_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("non_dg_cgo_status",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("scg_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rgn_shp_opr_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.scg.cargoloadingapproval.owndangerouscargoapproval.integration").append("\n"); 
		query.append("FileName : OwnDangerousCargoApprovalDBDAOScgNonDcgoRequestListRSQL").append("\n"); 
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
		query.append("SELECT    BKG_NO" ).append("\n"); 
		query.append("        , BKG_NO_POP" ).append("\n"); 
		query.append("        , NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("        , CNTR_NO" ).append("\n"); 
		query.append("        , VSL_CD" ).append("\n"); 
		query.append("        , SKD_VOY_NO" ).append("\n"); 
		query.append("        , SKD_DIR_CD" ).append("\n"); 
		query.append("	    , VVD" ).append("\n"); 
		query.append("        , SLAN_CD" ).append("\n"); 
		query.append("        , CSTMS_DESC" ).append("\n"); 
		query.append("        , CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("	    , CMDT_DESC" ).append("\n"); 
		query.append("        , XTER_RMK" ).append("\n"); 
		query.append("        , INTER_RMK" ).append("\n"); 
		query.append("        , SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("	    , ODEK_FLG" ).append("\n"); 
		query.append("	    , EML_SND_NO" ).append("\n"); 
		query.append("	    , EML_SND_NO_POP" ).append("\n"); 
		query.append("        , RQST_USR_ID" ).append("\n"); 
		query.append("        , RQST_OFC_CD" ).append("\n"); 
		query.append("        , RQST_DT" ).append("\n"); 
		query.append("	    , RQST_GDT" ).append("\n"); 
		query.append("        , EML_CTNT" ).append("\n"); 
		query.append("        , CRE_USR_ID" ).append("\n"); 
		query.append("        , CRE_DT" ).append("\n"); 
		query.append("        , UPD_USR_ID" ).append("\n"); 
		query.append("        , UPD_DT" ).append("\n"); 
		query.append("        , NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("        , NON_DCGO_KW_NM" ).append("\n"); 
		query.append("	    , POL_CD" ).append("\n"); 
		query.append("	    , USR_EML" ).append("\n"); 
		query.append("	    , DECODE(BKG_DCGO_FLG,'Y','DG','Normal') AS BKG_DCGO_FLG" ).append("\n"); 
		query.append("        , CNTR_DCGO_FLG" ).append("\n"); 
		query.append("		, STWG_CD" ).append("\n"); 
		query.append("		, POL_ETA_DT" ).append("\n"); 
		query.append("        ,( SELECT WM_CONCAT(DISTINCT IMDG_UN_NO) FROM BKG_DG_CGO" ).append("\n"); 
		query.append("            WHERE BKG_NO = A.BKG_NO) AS IMDG_UN_NO" ).append("\n"); 
		query.append("        , NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("        , NEW_CUST_APRO_RMK" ).append("\n"); 
		query.append("        , CMDT_NM" ).append("\n"); 
		query.append("        , CMT_CTNT" ).append("\n"); 
		query.append("FROM (SELECT B.BKG_NO" ).append("\n"); 
		query.append("            , B.BKG_NO AS BKG_NO_POP" ).append("\n"); 
		query.append("            , B.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("            , B.CNTR_NO" ).append("\n"); 
		query.append("            , B.VSL_CD" ).append("\n"); 
		query.append("            , B.SKD_VOY_NO" ).append("\n"); 
		query.append("            , B.SKD_DIR_CD" ).append("\n"); 
		query.append("            , B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD AS VVD" ).append("\n"); 
		query.append("            , B.SLAN_CD" ).append("\n"); 
		query.append("            , B.CSTMS_DESC" ).append("\n"); 
		query.append("            , B.CNTR_MF_GDS_DESC" ).append("\n"); 
		query.append("            , B.CMDT_DESC" ).append("\n"); 
		query.append("            , B.XTER_RMK" ).append("\n"); 
		query.append("            , B.INTER_RMK" ).append("\n"); 
		query.append("            , DECODE(B.SPCL_CGO_APRO_CD,'P','Pass','H','Hold','X','Undeclared') AS SPCL_CGO_APRO_CD" ).append("\n"); 
		query.append("            , DECODE(B.ODEK_FLG,'O','ON DECK','N/A') AS ODEK_FLG" ).append("\n"); 
		query.append("			, DECODE(NVL(B.EML_SND_NO,'N'),'N','N','Y') AS EML_SND_NO" ).append("\n"); 
		query.append("            , 'Send' AS EML_SND_NO_POP" ).append("\n"); 
		query.append("            , B.RQST_USR_ID" ).append("\n"); 
		query.append("            , B.RQST_OFC_CD" ).append("\n"); 
		query.append("            , B.RQST_DT" ).append("\n"); 
		query.append("            ,TO_CHAR(RQST_GDT,'YYYY-MM-DD HH24:MI:SS') AS RQST_GDT" ).append("\n"); 
		query.append("            , B.EML_CTNT" ).append("\n"); 
		query.append("            , B.CRE_USR_ID" ).append("\n"); 
		query.append("            , B.CRE_DT" ).append("\n"); 
		query.append("            , B.UPD_USR_ID" ).append("\n"); 
		query.append("            , DECODE(B.SPCL_CGO_APRO_CD,NULL,'',TO_CHAR(B.UPD_DT,'YYYY-MM-DD HH24:MI:SS')) UPD_DT" ).append("\n"); 
		query.append("            , A.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("            , A.NON_DCGO_KW_NM" ).append("\n"); 
		query.append("            , C.POL_CD" ).append("\n"); 
		query.append("            , (SELECT USR_EML FROM COM_USER WHERE USR_ID = C.DOC_USR_ID) AS USR_EML" ).append("\n"); 
		query.append("            , C.DCGO_FLG AS BKG_DCGO_FLG" ).append("\n"); 
		query.append("            , NVL((SELECT DCGO_FLG FROM BKG_CONTAINER WHERE BKG_NO = B.BKG_NO AND CNTR_NO = B.CNTR_NO),'N') AS CNTR_DCGO_FLG" ).append("\n"); 
		query.append("			, C.STWG_CD" ).append("\n"); 
		query.append("            ,(SELECT TO_CHAR(D.VPS_ETA_DT,'YYYY-MM-DD HH24:MI:SS')" ).append("\n"); 
		query.append("                FROM VSK_VSL_PORT_SKD D" ).append("\n"); 
		query.append("                WHERE 1=1" ).append("\n"); 
		query.append("                AND D.VSL_CD = B.VSL_CD" ).append("\n"); 
		query.append("                AND D.SKD_VOY_NO = B.SKD_VOY_NO" ).append("\n"); 
		query.append("                AND D.SKD_DIR_CD = B.SKD_DIR_CD" ).append("\n"); 
		query.append("                AND D.VPS_PORT_CD = C.POL_CD" ).append("\n"); 
		query.append("                AND D.CLPT_IND_SEQ = '1'" ).append("\n"); 
		query.append("             ) AS POL_ETA_DT" ).append("\n"); 
		query.append("            , B.NEW_CUST_APRO_CMDT_NM" ).append("\n"); 
		query.append("            , B.NEW_CUST_APRO_RMK" ).append("\n"); 
		query.append("            , NVL((SELECT CMDT.CMDT_NM FROM MDM_COMMODITY CMDT WHERE C.CMDT_CD = CMDT.CMDT_CD),'') AS CMDT_NM" ).append("\n"); 
		query.append("            , CMT_CTNT" ).append("\n"); 
		query.append("    FROM    (SELECT A.BKG_NO, A.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                    , TO_CHAR(WM_CONCAT(C.NON_DCGO_KW_SEQ)) AS NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("                    , TO_CHAR(WM_CONCAT(C.NON_DCGO_KW_NM)) AS NON_DCGO_KW_NM" ).append("\n"); 
		query.append("                    , WM_CONCAT(DISTINCT C.CMT_CTNT) AS CMT_CTNT" ).append("\n"); 
		query.append("            FROM SCG_NON_DG_CGO_KW_RQST A" ).append("\n"); 
		query.append("                , SCG_NON_DG_CGO_KW_RQST_DTL B" ).append("\n"); 
		query.append("                , SCG_NON_DG_CGO_KW C" ).append("\n"); 
		query.append("            WHERE 1=1" ).append("\n"); 
		query.append("            AND (A.BKG_NO, A.NON_DCGO_RQST_SEQ) IN (-- Status값이 있을경우(O)" ).append("\n"); 
		query.append("                                                    WITH TEMP AS (SELECT BKG_NO, MAX(NON_DCGO_RQST_SEQ) AS NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                                FROM SCG_NON_DG_CGO_KW_RQST" ).append("\n"); 
		query.append("                                                                WHERE 1=1" ).append("\n"); 
		query.append("                                                                AND SPCL_CGO_APRO_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                AND TO_CHAR(RQST_DT,'YYYY-MM-DD') BETWEEN @[rqst_fr_dt] AND @[rqst_to_dt]" ).append("\n"); 
		query.append("                                                                GROUP BY BKG_NO)" ).append("\n"); 
		query.append("                                                    SELECT A.BKG_NO, A.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                    FROM SCG_NON_DG_CGO_KW_RQST A, TEMP B" ).append("\n"); 
		query.append("                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                    AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                    AND A.NON_DCGO_RQST_SEQ = B.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                    -- Status값이 있을경우(O), 그 다음 차수중 Status값이 있는 keyword가 없는 시퀀스만 출력" ).append("\n"); 
		query.append("                                                    UNION ALL" ).append("\n"); 
		query.append("                                                    SELECT BKG_NO, NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                    FROM    (WITH TEMP AS (SELECT BKG_NO, MAX(NON_DCGO_RQST_SEQ) AS NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                                        FROM SCG_NON_DG_CGO_KW_RQST" ).append("\n"); 
		query.append("                                                                        WHERE 1=1" ).append("\n"); 
		query.append("                                                                        AND SPCL_CGO_APRO_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                        AND TO_CHAR(RQST_DT,'YYYY-MM-DD') BETWEEN @[rqst_fr_dt] AND @[rqst_to_dt]" ).append("\n"); 
		query.append("                                                                        GROUP BY BKG_NO)" ).append("\n"); 
		query.append("                                                            SELECT A.BKG_NO, A.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                            FROM SCG_NON_DG_CGO_KW_RQST_DTL A, TEMP B" ).append("\n"); 
		query.append("                                                            WHERE 1=1" ).append("\n"); 
		query.append("                                                            AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                            AND A.NON_DCGO_RQST_SEQ > B.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                            AND (A.BKG_NO, A.NON_DCGO_RQST_SEQ, A.NON_DCGO_KW_SEQ) NOT IN (WITH TEMP AS (SELECT BKG_NO, NON_DCGO_RQST_SEQ, NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("                                                                                                                                    FROM SCG_NON_DG_CGO_KW_RQST_DTL" ).append("\n"); 
		query.append("                                                                                                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                                                                                                    AND (BKG_NO, NON_DCGO_RQST_SEQ) IN (SELECT BKG_NO, MAX(NON_DCGO_RQST_SEQ) AS NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                                                                                                                                        FROM SCG_NON_DG_CGO_KW_RQST" ).append("\n"); 
		query.append("                                                                                                                                                                        WHERE 1=1" ).append("\n"); 
		query.append("                                                                                                                                                                        AND SPCL_CGO_APRO_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                                                                                                                        GROUP BY BKG_NO" ).append("\n"); 
		query.append("                                                                                                                                                                        )" ).append("\n"); 
		query.append("                                                                                                                                    )" ).append("\n"); 
		query.append("                                                                                                                            SELECT A.BKG_NO, A.NON_DCGO_RQST_SEQ, A.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("                                                                                                                            FROM SCG_NON_DG_CGO_KW_RQST_DTL A, TEMP B" ).append("\n"); 
		query.append("                                                                                                                            WHERE 1=1" ).append("\n"); 
		query.append("                                                                                                                            AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("                                                                                                                            AND A.NON_DCGO_RQST_SEQ > B.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                                                                                            AND A.NON_DCGO_KW_SEQ = B.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("                                                                                                                            )" ).append("\n"); 
		query.append("                                                            )" ).append("\n"); 
		query.append("                                                    -- Status값이 없는경우(X),   해당 부킹에 max" ).append("\n"); 
		query.append("                                                    UNION ALL" ).append("\n"); 
		query.append("                                                    SELECT BKG_NO, MAX(NON_DCGO_RQST_SEQ) AS NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                    FROM SCG_NON_DG_CGO_KW_RQST" ).append("\n"); 
		query.append("                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                    AND BKG_NO NOT IN (SELECT BKG_NO" ).append("\n"); 
		query.append("                                                                    FROM SCG_NON_DG_CGO_KW_RQST" ).append("\n"); 
		query.append("                                                                    WHERE 1=1" ).append("\n"); 
		query.append("                                                                    AND SPCL_CGO_APRO_CD IS NOT NULL" ).append("\n"); 
		query.append("                                                                    GROUP BY BKG_NO" ).append("\n"); 
		query.append("                                                                    )" ).append("\n"); 
		query.append("                                                    AND TO_CHAR(RQST_DT,'YYYY-MM-DD') BETWEEN @[rqst_fr_dt] AND @[rqst_to_dt]" ).append("\n"); 
		query.append("                                                    GROUP BY BKG_NO" ).append("\n"); 
		query.append("                                                    )" ).append("\n"); 
		query.append("            AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("            AND A.NON_DCGO_RQST_SEQ = B.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("            AND B.NON_DCGO_KW_SEQ = C.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("            AND C.NON_DCGO_CATE_GRP_CD = @[scg_flg]" ).append("\n"); 
		query.append("            AND C.DELT_FLG = 'N'" ).append("\n"); 
		query.append("            GROUP BY A.BKG_NO, A.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("			#if (${scg_flg} != 'A') " ).append("\n"); 
		query.append("            	HAVING  (SELECT COUNT(X.BKG_NO)" ).append("\n"); 
		query.append("                	        FROM SCG_NON_DG_CGO_KW_RQST_DTL X" ).append("\n"); 
		query.append("                    	        , SCG_NON_DG_CGO_KW Y" ).append("\n"); 
		query.append("                        	WHERE 1=1" ).append("\n"); 
		query.append("                        	AND X.BKG_NO = A.BKG_NO" ).append("\n"); 
		query.append("                        	AND X.NON_DCGO_KW_SEQ = Y.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("							#if (${scg_flg} == 'B') " ).append("\n"); 
		query.append("                        		AND Y.NON_DCGO_CATE_GRP_CD = 'A'" ).append("\n"); 
		query.append("							#elseif (${scg_flg} == 'C') " ).append("\n"); 
		query.append("								AND Y.NON_DCGO_CATE_GRP_CD IN ('A', 'B')" ).append("\n"); 
		query.append("							#else" ).append("\n"); 
		query.append("								AND Y.NON_DCGO_CATE_GRP_CD IN ('A', 'B', 'C')" ).append("\n"); 
		query.append("							#end" ).append("\n"); 
		query.append("                        	AND Y.DELT_FLG = 'N'" ).append("\n"); 
		query.append("                      	) = 0" ).append("\n"); 
		query.append("			#end" ).append("\n"); 
		query.append("            ) A" ).append("\n"); 
		query.append("            , SCG_NON_DG_CGO_KW_RQST B" ).append("\n"); 
		query.append("            , BKG_BOOKING C" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("    AND C.BKG_STS_CD <> 'X'" ).append("\n"); 
		query.append("    AND A.NON_DCGO_RQST_SEQ = B.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("    #if (${non_dg_cgo_status} == 'R') " ).append("\n"); 
		query.append("        AND B.SPCL_CGO_APRO_CD IS NULL" ).append("\n"); 
		query.append("    #else" ).append("\n"); 
		query.append("        AND B.SPCL_CGO_APRO_CD IN ( @[non_dg_cgo_status] )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	-- SLAN_CD 조건 사용안함 - 로직유지" ).append("\n"); 
		query.append("    #if ($slan_cd.size() > 0) " ).append("\n"); 
		query.append("        AND 	B.SLAN_CD IN ( " ).append("\n"); 
		query.append("                #foreach($key IN ${slan_cd}) " ).append("\n"); 
		query.append("                    #if($velocityCount < $slan_cd.size()) " ).append("\n"); 
		query.append("                        '$key', " ).append("\n"); 
		query.append("                    #else " ).append("\n"); 
		query.append("                        '$key' " ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("	-- RQST_OFC_CD 조건 사용" ).append("\n"); 
		query.append("    #if ($rqst_ofc_cd.size() > 0) " ).append("\n"); 
		query.append("        AND 	B.RQST_OFC_CD IN ( " ).append("\n"); 
		query.append("                #foreach($key IN ${rqst_ofc_cd}) " ).append("\n"); 
		query.append("                    #if($velocityCount < $rqst_ofc_cd.size()) " ).append("\n"); 
		query.append("                        '$key', " ).append("\n"); 
		query.append("                    #else " ).append("\n"); 
		query.append("                        '$key' " ).append("\n"); 
		query.append("                    #end " ).append("\n"); 
		query.append("                #end " ).append("\n"); 
		query.append("                )" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("    AND A.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("#if (${rgn_shp_opr_cd} != 'ALL') " ).append("\n"); 
		query.append("    AND (" ).append("\n"); 
		query.append("               @[rgn_shp_opr_cd] = " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT RGN_SHP_OPR_CD FROM SCG_RGN_SHP_OPR_PORT" ).append("\n"); 
		query.append("                WHERE   C.POL_CD 					= LOC_CD " ).append("\n"); 
		query.append("                AND     DELT_FLG 					= 'N'" ).append("\n"); 
		query.append("                AND		RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("            OR" ).append("\n"); 
		query.append("              @[rgn_shp_opr_cd] = " ).append("\n"); 
		query.append("            (" ).append("\n"); 
		query.append("                SELECT RGN_SHP_OPR_CD  FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("                 WHERE  (  SELECT OFC_N3RD_LVL_CD" ).append("\n"); 
		query.append("                             FROM DMT_OFC_LVL_V" ).append("\n"); 
		query.append("                            WHERE OFC_N8TH_LVL_CD = (SELECT  EQ_CTRL_OFC_CD FROM MDM_LOCATION" ).append("\n"); 
		query.append("                                                      WHERE  NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                                                        AND  LOC_CD  =   C.POL_CD)" ).append("\n"); 
		query.append("                    )   IN (RGN_SHP_OPR_RHQ_CD1, RGN_SHP_OPR_RHQ_CD2, RGN_SHP_OPR_RHQ_CD3, RGN_SHP_OPR_RHQ_CD4, RGN_SHP_OPR_RHQ_CD5, RGN_SHP_OPR_RHQ_CD6)" ).append("\n"); 
		query.append("                AND RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("                UNION" ).append("\n"); 
		query.append("                SELECT RGN_SHP_OPR_CD   FROM    SCG_RGN_SHP_OPR_CD" ).append("\n"); 
		query.append("                WHERE   (" ).append("\n"); 
		query.append("						SELECT	DECODE(SYS_AREA_GRP_ID, 'SWA', 'SINRS', 'EUR', 'HAMRU', 'USA', 'NYCRA', 'KOR', 'SHARC', 'CHN', 'SHARC')" ).append("\n"); 
		query.append("                        FROM	COM_SYS_AREA_GRP_ID A, MDM_LOCATION B" ).append("\n"); 
		query.append("                        WHERE	A.CO_IND_CD = 'H'" ).append("\n"); 
		query.append("                            AND A.CNT_CD = SUBSTR(B.LOC_CD, 1, 2)" ).append("\n"); 
		query.append("                            AND EQ_CTRL_OFC_CD IS NULL" ).append("\n"); 
		query.append("                        AND   NVL(DELT_FLG, 'N') = 'N'" ).append("\n"); 
		query.append("                        AND NVL(CALL_PORT_FLG, 'N') = 'Y'" ).append("\n"); 
		query.append("                        AND     B.LOC_CD  =   C.POL_CD)" ).append("\n"); 
		query.append("                IN (RGN_SHP_OPR_RHQ_CD1, RGN_SHP_OPR_RHQ_CD2, RGN_SHP_OPR_RHQ_CD3, RGN_SHP_OPR_RHQ_CD4, RGN_SHP_OPR_RHQ_CD5, RGN_SHP_OPR_RHQ_CD6)" ).append("\n"); 
		query.append("                AND RGN_SHP_OPR_CD 	= @[rgn_shp_opr_cd]" ).append("\n"); 
		query.append("            )" ).append("\n"); 
		query.append("           )" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append(") A" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("#if (${dg_flg} == '') " ).append("\n"); 
		query.append("   #if (${non_dg_cgo_status} != 'H' && ${non_dg_cgo_status} != 'X' )  -- 'U','X'인 경우는 BOOKING에 D/G여도 보여줌" ).append("\n"); 
		query.append("     AND (BKG_DCGO_FLG <> 'Y'  OR (  BKG_DCGO_FLG = 'Y' " ).append("\n"); 
		query.append("                              AND 'Y' = ( CASE WHEN ( SELECT COUNT(1) " ).append("\n"); 
		query.append("                                                        FROM SCG_NON_DG_CGO_KW_RQST_DTL X, SCG_NON_DG_CGO_KW Y" ).append("\n"); 
		query.append("                                                       WHERE X.NON_DCGO_KW_SEQ      = Y.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("                                                         AND X.BKG_NO               = A.BKG_NO" ).append("\n"); 
		query.append("                                                         AND X.NON_DCGO_RQST_SEQ    = A.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                                                         AND Y.NON_DCGO_CATE_GRP_CD = 'A' ) = 0 THEN 'N' " ).append("\n"); 
		query.append("                                               ELSE 'Y'" ).append("\n"); 
		query.append("                                           END ) " ).append("\n"); 
		query.append("                ))" ).append("\n"); 
		query.append("    #end" ).append("\n"); 
		query.append("#elseif(${dg_flg} == 'N') " ).append("\n"); 
		query.append("AND BKG_DCGO_FLG <> 'Y'" ).append("\n"); 
		query.append("#elseif(${dg_flg} == 'D') " ).append("\n"); 
		query.append(" #if (${non_dg_cgo_status} == 'H' || ${non_dg_cgo_status} == 'X')" ).append("\n"); 
		query.append("    AND BKG_DCGO_FLG = 'Y' " ).append("\n"); 
		query.append(" #else" ).append("\n"); 
		query.append("    AND BKG_DCGO_FLG = 'Y' " ).append("\n"); 
		query.append("    AND 'Y' = ( CASE WHEN ( SELECT COUNT(1) " ).append("\n"); 
		query.append("                              FROM SCG_NON_DG_CGO_KW_RQST_DTL X, SCG_NON_DG_CGO_KW Y" ).append("\n"); 
		query.append("                             WHERE X.NON_DCGO_KW_SEQ      = Y.NON_DCGO_KW_SEQ" ).append("\n"); 
		query.append("                               AND X.BKG_NO               = A.BKG_NO" ).append("\n"); 
		query.append("                               AND X.NON_DCGO_RQST_SEQ    = A.NON_DCGO_RQST_SEQ" ).append("\n"); 
		query.append("                               AND Y.NON_DCGO_CATE_GRP_CD = 'A' ) = 0 THEN 'N'" ).append("\n"); 
		query.append("                     ELSE 'Y'" ).append("\n"); 
		query.append("                 END )" ).append("\n"); 
		query.append("  #end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND TO_CHAR(RQST_DT,'YYYY-MM-DD') BETWEEN @[rqst_fr_dt] AND @[rqst_to_dt]" ).append("\n"); 
		query.append("ORDER BY BKG_NO, NON_DCGO_RQST_SEQ" ).append("\n"); 

	}
}