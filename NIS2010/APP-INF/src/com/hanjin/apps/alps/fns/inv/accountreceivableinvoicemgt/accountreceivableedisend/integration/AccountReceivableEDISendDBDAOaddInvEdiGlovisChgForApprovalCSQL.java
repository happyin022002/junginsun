/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : AccountReceivableEDISendDBDAOaddInvEdiGlovisChgForApprovalCSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.05
*@LastModifier : 
*@LastVersion : 1.0
* 2011.10.05 
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

public class AccountReceivableEDISendDBDAOaddInvEdiGlovisChgForApprovalCSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Glovis에서 청구 승인이 온이후에 C/A가 발생해서
	  * 다시 전송시에는 
	  * A/R main table과 Glovis EDI charge table의 차액 만큼만 입력한다.
	  * </pre>
	  */
	public AccountReceivableEDISendDBDAOaddInvEdiGlovisChgForApprovalCSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("eur_gubun",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("io_bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("euro_locl_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("ar_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("inv_xch_rt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_src_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cre_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.integration").append("\n"); 
		query.append("FileName : AccountReceivableEDISendDBDAOaddInvEdiGlovisChgForApprovalCSQL").append("\n"); 
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
		query.append("INSERT INTO INV_EDI_GLOVIS_CHG" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("AR_IF_NO, IF_SEQ, CHG_SEQ, CHG_CD" ).append("\n"); 
		query.append(", CURR_CD, PER_TP_CD, TRF_RT_AMT, RAT_AS_CNTR_QTY, CHG_AMT, INV_XCH_RT, CHG_RMK" ).append("\n"); 
		query.append(", CRE_USR_ID, CRE_DT, UPD_USR_ID, UPD_DT" ).append("\n"); 
		query.append(", EURO_LOCL_XCH_RT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SELECT  @[ar_if_no]" ).append("\n"); 
		query.append(", (SELECT NVL(MAX(IF_SEQ), 1)" ).append("\n"); 
		query.append("FROM   INV_EDI_GLOVIS_HDR" ).append("\n"); 
		query.append("WHERE  AR_IF_NO = @[ar_if_no]" ).append("\n"); 
		query.append(") AS IF_SEQ" ).append("\n"); 
		query.append(", ROW_NUMBER() OVER(ORDER BY 4,5,6,7) AS CHG_SEQ" ).append("\n"); 
		query.append(", CHG_CD" ).append("\n"); 
		query.append(", CURR_CD" ).append("\n"); 
		query.append(", PER_TP_CD" ).append("\n"); 
		query.append(", TRF_RT_AMT" ).append("\n"); 
		query.append(", CNTR_QTY" ).append("\n"); 
		query.append(", DIF_CHG_AMT" ).append("\n"); 
		query.append(", INV_XCH_RT" ).append("\n"); 
		query.append(", '' AS CHG_RMK" ).append("\n"); 
		query.append(", @[cre_usr_id], SYSDATE,@[upd_usr_id], SYSDATE" ).append("\n"); 
		query.append(", EURO_LOCL_XCH_RT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT    NVL(T2.CHG_CD     , T1.CHG_CD     ) AS CHG_CD" ).append("\n"); 
		query.append(", NVL(T2.CURR_CD    , T1.CURR_CD    ) AS CURR_CD" ).append("\n"); 
		query.append(", NVL(T2.PER_TP_CD  , T1.PER_TP_CD  ) AS PER_TP_CD" ).append("\n"); 
		query.append(", NVL(T2.TRF_RT_AMT , T1.TRF_RT_AMT ) AS TRF_RT_AMT" ).append("\n"); 
		query.append(", NVL(T2.CNTR_QTY   , T1.CNTR_QTY   ) AS CNTR_QTY" ).append("\n"); 
		query.append(", (NVL(T2.CHG_AMT, 0) - NVL(T1.CHG_AMT,0)) AS DIF_CHG_AMT" ).append("\n"); 
		query.append(", DECODE(NVL(T2.CURR_CD, T1.CURR_CD)              , 'KRW' , 1                  , @[inv_xch_rt]      ) AS INV_XCH_RT" ).append("\n"); 
		query.append(", DECODE(NVL(T2.CURR_CD, T1.CURR_CD)||@[eur_gubun], 'USDY', @[euro_locl_xch_rt],                  0 ) AS EURO_LOCL_XCH_RT" ).append("\n"); 
		query.append("-- 구주발 OUT BOUND, USD CHARGE 존재할 경우 EUR EXCHAGE RATE" ).append("\n"); 
		query.append("FROM    (" ).append("\n"); 
		query.append("-- 청구 승인에 합" ).append("\n"); 
		query.append("SELECT  T2.CHG_CD, T2.CURR_CD, T2.PER_TP_CD" ).append("\n"); 
		query.append(", T2.TRF_RT_AMT" ).append("\n"); 
		query.append(", T2.RAT_AS_CNTR_QTY        AS CNTR_QTY" ).append("\n"); 
		query.append(", SUM(T2.CHG_AMT        )   AS CHG_AMT" ).append("\n"); 
		query.append("FROM    INV_EDI_GLOVIS_HDR T1, INV_EDI_GLOVIS_CHG T2" ).append("\n"); 
		query.append("WHERE   T1.AR_IF_NO        = T2.AR_IF_NO" ).append("\n"); 
		query.append("AND     T1.IF_SEQ          = T2.IF_SEQ" ).append("\n"); 
		query.append("AND     T1.BL_SRC_NO       = @[bl_src_no]" ).append("\n"); 
		query.append("AND     T1.RE_TP_CD        = 'A'" ).append("\n"); 
		query.append("GROUP BY T2.CHG_CD, T2.CURR_CD, T2.PER_TP_CD, T2.TRF_RT_AMT,T2.RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(")  T1 FULL OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("-- INV C/A" ).append("\n"); 
		query.append("SELECT  CHG_CD, CURR_CD,PER_TP_CD,TRF_RT_AMT,RAT_AS_CNTR_QTY AS CNTR_QTY," ).append("\n"); 
		query.append("SUM(CHG_AMT) CHG_AMT" ).append("\n"); 
		query.append("FROM    INV_AR_MN T1, INV_AR_CHG T2" ).append("\n"); 
		query.append("WHERE   T1.BL_SRC_NO       = @[bl_src_no] --C/A가 발생한 I/F NO" ).append("\n"); 
		query.append("AND     T1.AR_IF_NO        = T2.AR_IF_NO" ).append("\n"); 
		query.append("AND     T1.AR_OFC_CD       = @[ar_ofc_cd]" ).append("\n"); 
		query.append("AND     T1.IO_BND_CD       = @[io_bnd_cd]" ).append("\n"); 
		query.append("AND     T1.ACT_CUST_CNT_CD = 'KR'" ).append("\n"); 
		query.append("AND     T1.ACT_CUST_SEQ    = 19575" ).append("\n"); 
		query.append("AND     T1.REV_TP_CD       IN ('B', 'C')" ).append("\n"); 
		query.append("GROUP BY CHG_CD, CURR_CD,PER_TP_CD,TRF_RT_AMT,RAT_AS_CNTR_QTY" ).append("\n"); 
		query.append(") T2 ON" ).append("\n"); 
		query.append("(       T1.CHG_CD       = T2.CHG_CD" ).append("\n"); 
		query.append("AND     T1.CURR_CD      = T2.CURR_CD" ).append("\n"); 
		query.append("AND     T1.PER_TP_CD    = T2.PER_TP_CD" ).append("\n"); 
		query.append("AND     T1.CNTR_QTY     = T2.CNTR_QTY" ).append("\n"); 
		query.append("AND     T1.TRF_RT_AMT   = T2.TRF_RT_AMT" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE DIF_CHG_AMT <>0" ).append("\n"); 

	}
}