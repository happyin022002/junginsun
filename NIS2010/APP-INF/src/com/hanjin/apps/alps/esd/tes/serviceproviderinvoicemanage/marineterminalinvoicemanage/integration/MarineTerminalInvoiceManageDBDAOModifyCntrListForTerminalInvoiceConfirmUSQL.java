/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : MarineTerminalInvoiceManageDBDAOModifyCntrListForTerminalInvoiceConfirmUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.02.08
*@LastModifier : 
*@LastVersion : 1.0
* 2017.02.08 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class MarineTerminalInvoiceManageDBDAOModifyCntrListForTerminalInvoiceConfirmUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * ModifyCntrListForTerminalInvoiceConfirm
	  * </pre>
	  */
	public MarineTerminalInvoiceManageDBDAOModifyCntrListForTerminalInvoiceConfirmUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
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
		params.put("tml_so_ofc_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tml_so_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.integration").append("\n"); 
		query.append("FileName : MarineTerminalInvoiceManageDBDAOModifyCntrListForTerminalInvoiceConfirmUSQL").append("\n"); 
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
		query.append("UPDATE TES_TML_SO_DTL OUTER" ).append("\n"); 
		query.append("SET (" ).append("\n"); 
		query.append("  OUTER.UPD_USR_ID" ).append("\n"); 
		query.append("  ,OUTER.UPD_DT" ).append("\n"); 
		query.append("  ,OUTER.LOCL_UPD_DT		" ).append("\n"); 
		query.append("　,OUTER.ACCT_CD" ).append("\n"); 
		query.append(") = (" ).append("\n"); 
		query.append("    SELECT @[usr_id] UPD_USR_ID  									-- UPDATE DATA" ).append("\n"); 
		query.append("		   ,SYSDATE  UPD_DT										" ).append("\n"); 
		query.append("           ,GLOBALDATE_PKG.TIME_LOCAL_OFC_FNC(@[ofc_cd])	LOCL_UPD_DT-- UPDATE DATA" ).append("\n"); 
		query.append("           , DECODE(D.TML_CRR_CD,NULL,C.ACCT_CD,'',C.ACCT_CD,'SML',C.ACCT_CD,C.CRR_ACCT_CD) ACCT_CD    -- 2008-07-31: 이D의 요청으로 전용terminal이외도 타선사인경우 타선사 Acct를 물린다." ).append("\n"); 
		query.append("    FROM   TES_TML_SO_HDR H, TES_TML_SO_DTL D, TES_LGS_COST C" ).append("\n"); 
		query.append("    WHERE  D.TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND    D.TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("    AND    H.TML_SO_OFC_CTY_CD = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND    H.TML_SO_SEQ = D.TML_SO_SEQ" ).append("\n"); 
		query.append("    AND    D.LGS_COST_CD = C.LGS_COST_CD(+)" ).append("\n"); 
		query.append("    AND    OUTER.TML_SO_OFC_CTY_CD      = D.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND    OUTER.TML_SO_SEQ             = D.TML_SO_SEQ" ).append("\n"); 
		query.append("    AND    OUTER.TML_SO_DTL_SEQ         = D.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append(" where exists" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT 'X'" ).append("\n"); 
		query.append("    FROM   TES_TML_SO_DTL B" ).append("\n"); 
		query.append("    WHERE  TML_SO_OFC_CTY_CD = @[tml_so_ofc_cty_cd]" ).append("\n"); 
		query.append("    AND    TML_SO_SEQ        = @[tml_so_seq]" ).append("\n"); 
		query.append("    AND    OUTER.TML_SO_OFC_CTY_CD      = B.TML_SO_OFC_CTY_CD" ).append("\n"); 
		query.append("    AND    OUTER.TML_SO_SEQ             = B.TML_SO_SEQ" ).append("\n"); 
		query.append("    AND    OUTER.TML_SO_DTL_SEQ         = B.TML_SO_DTL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}