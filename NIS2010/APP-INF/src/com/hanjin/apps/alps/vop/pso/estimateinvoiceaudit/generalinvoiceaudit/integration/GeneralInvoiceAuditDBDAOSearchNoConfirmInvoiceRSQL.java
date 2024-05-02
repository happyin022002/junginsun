/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : GeneralInvoiceAuditDBDAOSearchNoConfirmInvoiceRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.01.10
*@LastModifier : 진마리아
*@LastVersion : 1.0
* 2012.01.10 진마리아
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Maria Chin
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralInvoiceAuditDBDAOSearchNoConfirmInvoiceRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 유저가 생성한 invoice 중, 미 confirm된 invoice list를 조회한다.
	  * 
	  * ==============================================
	  * history
	  * * 2012.01.10 진마리아 선처리(SRM-201222935) invoice creation 화면 오픈시 미 Confirm된 Invoice List Notice 메시지 alert
	  * </pre>
	  */
	public GeneralInvoiceAuditDBDAOSearchNoConfirmInvoiceRSQL(){
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

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.generalinvoiceaudit.integration").append("\n"); 
		query.append("FileName : GeneralInvoiceAuditDBDAOSearchNoConfirmInvoiceRSQL").append("\n"); 
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
		query.append("SELECT M.INV_NO||' '||M.VNDR_SEQ||' '||D.VSL_CD||D.SKD_VOY_NO||D.SKD_DIR_CD||' '||(SELECT ACCT_CD FROM TES_LGS_COST WHERE LGS_COST_CD=D.LGS_COST_CD)" ).append("\n"); 
		query.append("FROM PSO_CHARGE M, PSO_CHG_DTL D" ).append("\n"); 
		query.append("WHERE M.ISS_CTY_CD = D.ISS_CTY_CD" ).append("\n"); 
		query.append("AND M.SO_SEQ = D.SO_SEQ" ).append("\n"); 
		query.append("#if (${usr_id} != '') " ).append("\n"); 
		query.append("AND M.CRE_USR_ID = @[usr_id]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND M.INV_RGST_NO IS NULL" ).append("\n"); 
		query.append("GROUP BY M.INV_NO, M.VNDR_SEQ, D.VSL_CD, D.SKD_VOY_NO, D.SKD_DIR_CD, D.LGS_COST_CD" ).append("\n"); 
		query.append("ORDER BY VSL_CD, SKD_VOY_NO, SKD_DIR_CD" ).append("\n"); 

	}
}