/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CntrSafetyStockManageDBDAOSearchCntrSafetyStockQtyRSQL.java
*@FileTitle : Safty Stock
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 이행지
*@LastVersion : 1.0
* 2009.08.11 이행지
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Haeng-ji,Lee
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CntrSafetyStockManageDBDAOSearchCntrSafetyStockQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EES_EQR_0026 ; Safty Stock 
	  *  - EQR_ECC_SFT_STK_BSS  테이블 에서 특정 ecc, type size 의 qty 조회
	  * </pre>
	  */
	public CntrSafetyStockManageDBDAOSearchCntrSafetyStockQtyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ecc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sfstk_lvl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.eqr.scenariomanage.cntrsafetystockmanage.integration").append("\n"); 
		query.append("FileName : CntrSafetyStockManageDBDAOSearchCntrSafetyStockQtyRSQL").append("\n"); 
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
		query.append("SELECT	SFSTK_VOL_QTY" ).append("\n"); 
		query.append("FROM	EQR_ECC_SFT_STK_BSS" ).append("\n"); 
		query.append("WHERE	ECC_CD = @[ecc_cd]" ).append("\n"); 
		query.append("AND	CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("AND	SFSTK_LVL_CD = @[sfstk_lvl_cd]" ).append("\n"); 
		query.append("AND	NVL(DELT_FLG,'N') = 'N' -- CSRNO : N200810210009의거 추가" ).append("\n"); 

	}
}