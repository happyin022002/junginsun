/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOsearchEdiGlovisMsgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.24
*@LastModifier : 
*@LastVersion : 1.0
* 2017.01.24 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class AccountReceivableEDISendDBDAOsearchEdiGlovisMsgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * glovis 취소 전송 메세지 만들기
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOsearchEdiGlovisMsgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("if_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_eml",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ar_if_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cxl_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cust_nm",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("usr_eml",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOsearchEdiGlovisMsgRSQL").append("\n"); 
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
		query.append("SELECT SEQNUM" ).append("\n"); 
		query.append(", '$$$MSGSTART:E811                GLOVIS              FRTINV    '||'INV'||TO_CHAR(SYSDATE,'YYYYMMDDHH24MM')||TO_CHAR(TRUNC(DBMS_RANDOM.VALUE()*100000)) AS INTERNAL_HEADER" ).append("\n"); 
		query.append(", 'FRTINV'||'E811                ' || 'GLOVIS'            AS HEADER" ).append("\n"); 
		query.append(", '1.00'                        AS MSGVER" ).append("\n"); 
		query.append(", MSGNUM                        AS MSGNUM" ).append("\n"); 
		query.append(", INVYMD                        AS SNDDAT" ).append("\n"); 
		query.append(", HDR_STR" ).append("\n"); 
		query.append("||CHR(10)||'INVNUM:' || INVNUM" ).append("\n"); 
		query.append("||CHR(10)||'MSGGUB:' || MSGGUB" ).append("\n"); 
		query.append("||CHR(10)||'AIRSEA:' || AIRSEA" ).append("\n"); 
		query.append("||CHR(10)||'INOUTC:' || INOUTC" ).append("\n"); 
		query.append("||CHR(10)||'CSTCOD:' || CSTCOD" ).append("\n"); 
		query.append("||CHR(10)||'CSTNAM:' || CSTNAM" ).append("\n"); 
		query.append("||CHR(10)||'CSTTYP:' || CSTTYP" ).append("\n"); 
		query.append("||CHR(10)||'REGNUM:' || REGNUM" ).append("\n"); 
		query.append("||CHR(10)||'INVYMD:' || INVYMD" ).append("\n"); 
		query.append("||CHR(10)||'SNDEML:' || SNDEML" ).append("\n"); 
		query.append("||CHR(10)||'SNDNAM:' || SNDNAM" ).append("\n"); 
		query.append("||CHR(10)||'SNDPHN:' || SNDPHN" ).append("\n"); 
		query.append("||CHR(10)||'RCVEML:' || RCVEML" ).append("\n"); 
		query.append("||CHR(10)||'RCVNAM:' || RCVNAM" ).append("\n"); 
		query.append("||CHR(10)||" ).append("\n"); 
		query.append("HDR_END                         AS HDR_MSG" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(", DTL_STR" ).append("\n"); 
		query.append("||CHR(10)||'SEQNUM:' || SEQNUM     " ).append("\n"); 
		query.append("||CHR(10)||'FBLNUM:' || FBLNUM     " ).append("\n"); 
		query.append("||CHR(10)||'FRTCOD:' || FRTCOD     " ).append("\n"); 
		query.append("||CHR(10)||'FRTNAM:' || FRTNAM     " ).append("\n"); 
		query.append("||CHR(10)||'AGRCUR:' || AGRCUR     " ).append("\n"); 
		query.append("||CHR(10)||'PKGUNT:' || PKGUNT     " ).append("\n"); 
		query.append("||CHR(10)||'UNTPRC:' || UNTPRC     " ).append("\n"); 
		query.append("||CHR(10)||'PKGCNT:' || PKGCNT     " ).append("\n"); 
		query.append("||CHR(10)||'FRTAMT:' || FRTAMT     " ).append("\n"); 
		query.append("||CHR(10)||'EXCRAT:' || EXCRAT     " ).append("\n"); 
		query.append("||CHR(10)||'WONAMT:' || WONAMT     " ).append("\n"); 
		query.append("||CHR(10)||'VATAMT:' || VATAMT     " ).append("\n"); 
		query.append("||CHR(10)||'INVCUR:' || INVCUR     " ).append("\n"); 
		query.append("||CHR(10)||'DETRMK:' || DETRMK     " ).append("\n"); 
		query.append("||CHR(10)|| " ).append("\n"); 
		query.append("DTL_END AS DETAIL_MSG" ).append("\n"); 
		query.append("FROM    (/*T01*/" ).append("\n"); 
		query.append("SELECT  ROW_NUMBER() OVER(ORDER BY T2.CHG_SEQ)                                      AS SEQNUM" ).append("\n"); 
		query.append("        , '{INV_HEADER'                                                             AS HDR_STR" ).append("\n"); 
		query.append("        , '}INV_HEADER'                                                             AS HDR_END" ).append("\n"); 
		query.append("        , T1.GLOVIS_EDI_MSG_NO                                                      AS MSGNUM" ).append("\n"); 
		query.append("        , T1.INV_NO||DECODE(T1.INV_SEQ,0,'',T1.INV_SEQ)                             AS INVNUM" ).append("\n"); 
		query.append("        , DECODE(@[cxl_flg], 'Y', 'D', 'A')                                         AS MSGGUB" ).append("\n"); 
		query.append("        , 'S'                                                                       AS AIRSEA" ).append("\n"); 
		query.append("        , T1.IO_BND_CD                                                              AS INOUTC" ).append("\n"); 
		query.append("        , 'E811'                                                                    AS CSTCOD" ).append("\n"); 
		query.append("        , T5.LOCL_NM                                                                AS CSTNAM" ).append("\n"); 
		query.append("        , 'L'                                                                       AS CSTTYP" ).append("\n"); 
		query.append("        , T6.CUST_RGST_NO                                                           AS REGNUM" ).append("\n"); 
		query.append("        , TO_CHAR(SYSDATE, 'YYYYMMDD')                                              AS INVYMD" ).append("\n"); 
		query.append("        , @[usr_eml]                                                                AS SNDEML" ).append("\n"); 
		query.append("        , @[usr_id]                                                                 AS SNDNAM" ).append("\n"); 
		query.append("        , 0                                                                         AS SNDPHN" ).append("\n"); 
		query.append("        , @[cust_eml]                                                               AS RCVEML" ).append("\n"); 
		query.append("        , @[cust_nm]                                                                AS RCVNAM" ).append("\n"); 
		query.append("        , '{INV_DETAIL'                                                             AS DTL_STR" ).append("\n"); 
		query.append("        , '}INV_DETAIL'                                                             AS DTL_END" ).append("\n"); 
		query.append("        , 'SMLM'||BL_SRC_NO                                                         AS FBLNUM" ).append("\n"); 
		query.append("        , NVL(T2.CHG_CD," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("              SELECT    CUST_CD_VAL_CTNT" ).append("\n"); 
		query.append("              FROM      INV_EDI_INTG_CD_DTL" ).append("\n"); 
		query.append("              WHERE     INTG_CD_ID      = 'CD00001'" ).append("\n"); 
		query.append("              AND       HJS_CD_VAL_CTNT = 'XXX'" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          )                                                                         AS FRTCOD" ).append("\n"); 
		query.append("        , NVL(T2.CHG_CD_DESC," ).append("\n"); 
		query.append("              (" ).append("\n"); 
		query.append("              SELECT    CUST_CD_VAL_DESC" ).append("\n"); 
		query.append("              FROM      INV_EDI_INTG_CD_DTL" ).append("\n"); 
		query.append("              WHERE     INTG_CD_ID      = 'CD00001'" ).append("\n"); 
		query.append("              AND       HJS_CD_VAL_CTNT = 'XXX'" ).append("\n"); 
		query.append("              )" ).append("\n"); 
		query.append("          )                                                                         AS FRTNAM" ).append("\n"); 
		query.append("        , DECODE(T2.CURR_CD||T2.EUR_GUBUN, 'USDY', 'EUR', T2.CURR_CD)               AS AGRCUR" ).append("\n"); 
		query.append("        , T2.PER_TP_CD                                                              AS PKGUNT" ).append("\n"); 
		query.append("        , T2.TRF_RT_AMT                                                             AS UNTPRC" ).append("\n"); 
		query.append("        , T2.RAT_AS_CNTR_QTY                                                        AS PKGCNT" ).append("\n"); 
		query.append("        , DECODE(T2.CURR_CD||T2.EUR_GUBUN, 'USDY'" ).append("\n"); 
		query.append("                  , ROUND((T2.CHG_AMT * T2.INV_XCH_RT) / T2.EURO_LOCL_XCH_RT, 2)" ).append("\n"); 
		query.append("                  , T2.CHG_AMT                                        )             AS FRTAMT" ).append("\n"); 
		query.append("        , DECODE(T2.CURR_CD||T2.EUR_GUBUN, 'USDY'" ).append("\n"); 
		query.append("                  , T2.EURO_LOCL_XCH_RT" ).append("\n"); 
		query.append("                  , T2.INV_XCH_RT                                     )             AS EXCRAT" ).append("\n"); 
		query.append("        , DECODE(T2.CURR_CD||T2.EUR_GUBUN, 'USDY'" ).append("\n"); 
		query.append("                  , ROUND(ROUND((T2.CHG_AMT * T2.INV_XCH_RT) / T2.EURO_LOCL_XCH_RT, 2) * T2.EURO_LOCL_XCH_RT, 0)" ).append("\n"); 
		query.append("                  , ROUND(T2.CHG_AMT  * T2.INV_XCH_RT , 0)            )             AS WONAMT " ).append("\n"); 
		query.append("        , ''                                                                        AS VATAMT" ).append("\n"); 
		query.append("        , DECODE(T2.CURR_CD, 'KRW', 'K', 'U')                                       AS INVCUR" ).append("\n"); 
		query.append("        , ''                                                                        AS DETRMK" ).append("\n"); 
		query.append("FROM    INV_EDI_GLOVIS_HDR  T1," ).append("\n"); 
		query.append("        MDM_CR_CUST         T5," ).append("\n"); 
		query.append("        MDM_CUSTOMER        T6," ).append("\n"); 
		query.append("        (SELECT   B.CUST_CD_VAL_CTNT AS CHG_CD" ).append("\n"); 
		query.append("                , B.CUST_CD_VAL_DESC AS CHG_CD_DESC" ).append("\n"); 
		query.append("                , C.CUST_CD_VAL_CTNT AS PER_TP_CD" ).append("\n"); 
		query.append("                , A.TRF_RT_AMT, A.RAT_AS_CNTR_QTY, A.CHG_AMT" ).append("\n"); 
		query.append("                , CASE WHEN (A.CURR_CD = 'USD' AND NVL(A.EURO_LOCL_XCH_RT, 0) > 0 ) THEN" ).append("\n"); 
		query.append("                    'Y'                        -- EUR일 경우 EURO_LOCL_XCH_RT 값이 입력된다." ).append("\n"); 
		query.append("                  ELSE" ).append("\n"); 
		query.append("                    'N'" ).append("\n"); 
		query.append("                  END AS EUR_GUBUN             -- 2011.08.29" ).append("\n"); 
		query.append("                , A.INV_XCH_RT" ).append("\n"); 
		query.append("                , A.EURO_LOCL_XCH_RT           -- EUR일 경우 EURO_LOCL_XCH_RT 값이 입력된다." ).append("\n"); 
		query.append("                , A.AR_IF_NO, A.IF_SEQ, A.CURR_CD, A.CHG_SEQ" ).append("\n"); 
		query.append("         FROM   INV_EDI_GLOVIS_CHG  A" ).append("\n"); 
		query.append("              , INV_EDI_INTG_CD_DTL B" ).append("\n"); 
		query.append("              , INV_EDI_INTG_CD_DTL C" ).append("\n"); 
		query.append("         WHERE  A.CHG_CD           = B.HJS_CD_VAL_CTNT (+)" ).append("\n"); 
		query.append("         AND    B.INTG_CD_ID (+)   = 'CD00001'" ).append("\n"); 
		query.append("         AND    A.PER_TP_CD        = C.HJS_CD_VAL_CTNT" ).append("\n"); 
		query.append("         AND    C.INTG_CD_ID       = 'CD00002'" ).append("\n"); 
		query.append("         AND    A.AR_IF_NO         = @[ar_if_no]" ).append("\n"); 
		query.append("         AND    A.IF_SEQ           = @[if_seq]" ).append("\n"); 
		query.append("        )   T2      " ).append("\n"); 
		query.append("WHERE   1=1" ).append("\n"); 
		query.append("AND     T1.AR_IF_NO         = T2.AR_IF_NO   (+)" ).append("\n"); 
		query.append("AND     T1.IF_SEQ           = T2.IF_SEQ     (+)" ).append("\n"); 
		query.append("AND     T1.CUST_CNT_CD      = T5.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     T1.CUST_SEQ         = T5.CUST_SEQ   (+)" ).append("\n"); 
		query.append("AND     T1.CUST_CNT_CD      = T6.CUST_CNT_CD(+)" ).append("\n"); 
		query.append("AND     T1.CUST_SEQ         = T6.CUST_SEQ   (+)" ).append("\n"); 
		query.append("AND     T1.AR_IF_NO         = @[ar_if_no]" ).append("\n"); 
		query.append("AND     T1.IF_SEQ           = @[if_seq]" ).append("\n"); 
		query.append(") T01" ).append("\n"); 

	}
}