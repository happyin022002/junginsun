/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : PayableRentalCostDBDAOLseOpLseVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.12.29
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.12.29 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Nho Jung Yong
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class PayableRentalCostDBDAOLseOpLseVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public PayableRentalCostDBDAOLseOpLseVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bil_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerrentalcost.payablerentalcost.integration").append("\n"); 
		query.append("FileName : PayableRentalCostDBDAOLseOpLseVORSQL").append("\n"); 
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
		query.append("SELECT A.OP_LSE_STS_CD" ).append("\n"); 
		query.append(", A.VNDR_SEQ" ).append("\n"); 
		query.append(", DECODE(A.VNDR_SEQ, 146684, 'UNITAS', 2444, 'ICC') AS VNDR_NM" ).append("\n"); 
		query.append(", TO_CHAR(A.BIL_FM_DT, 'YYYYMMDD') AS BIL_FM_DT" ).append("\n"); 
		query.append(", TO_CHAR(A.BIL_TO_DT, 'YYYYMMDD') AS BIL_TO_DT" ).append("\n"); 
		query.append(", A.VSL_CD" ).append("\n"); 
		query.append(", A.SKD_VOY_NO" ).append("\n"); 
		query.append(", A.SKD_DIR_CD" ).append("\n"); 
		query.append(", A.REV_DIR_CD" ).append("\n"); 
		query.append(", TO_CHAR(A.PAY_DT, 'YYYYMMDD') AS PAY_DT" ).append("\n"); 
		query.append(", A.CNTR_TPSZ_CD" ).append("\n"); 
		query.append(", A.AGMT_CTY_CD || LPAD(A.AGMT_SEQ, 6, '0') AS AGMT_NO" ).append("\n"); 
		query.append(", A.AGMT_REF_NO" ).append("\n"); 
		query.append(", B.VNDR_LGL_ENG_NM" ).append("\n"); 
		query.append(", A.CURR_CD" ).append("\n"); 
		query.append(", A.PRIN_AMT" ).append("\n"); 
		query.append(", A.BAL_AMT" ).append("\n"); 
		query.append(", A.INT_AMT" ).append("\n"); 
		query.append(", A.LIBOR_AMT" ).append("\n"); 
		query.append(", A.PAY_AMT" ).append("\n"); 
		query.append(", A.INV_NO" ).append("\n"); 
		query.append(", A.DIFF_RMK" ).append("\n"); 
		query.append(", C.LSE_CTRT_NO" ).append("\n"); 
		query.append(", A.OP_SEQ" ).append("\n"); 
		query.append(", A.AGMT_CTY_CD" ).append("\n"); 
		query.append(", A.AGMT_SEQ" ).append("\n"); 
		query.append(", D.ACCT_CD" ).append("\n"); 
		query.append(", D.COST_CD" ).append("\n"); 
		query.append(", A.OP_LSE_QTY" ).append("\n"); 
		query.append(", E.LGS_COST_FULL_NM AS COST_NM" ).append("\n"); 
		query.append("FROM   LSE_OP_LSE    A" ).append("\n"); 
		query.append(", MDM_VENDOR    B" ).append("\n"); 
		query.append(", LSE_AGREEMENT C" ).append("\n"); 
		query.append(", LSE_RNTL_COST_ACCT_ORD D" ).append("\n"); 
		query.append(", TES_LGS_COST  E" ).append("\n"); 
		query.append("WHERE  A.VNDR_SEQ = @[vndr_seq]" ).append("\n"); 
		query.append("AND    A.BIL_FM_DT <= TO_DATE(@[bil_to_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("AND    A.BIL_TO_DT >= TO_DATE(@[bil_fm_dt], 'YYYYMMDD')" ).append("\n"); 
		query.append("AND    B.VNDR_SEQ = A.VNDR_SEQ" ).append("\n"); 
		query.append("AND    A.AGMT_CTY_CD = C.AGMT_CTY_CD" ).append("\n"); 
		query.append("AND    A.AGMT_SEQ = C.AGMT_SEQ" ).append("\n"); 
		query.append("AND    A.OP_LSE_STS_CD <> 'D'" ).append("\n"); 
		query.append("AND    D.LSE_RCV_CHG_TP_CD = 'OPL'" ).append("\n"); 
		query.append("AND    D.LSTM_CD = 'XX'" ).append("\n"); 
		query.append("AND    D.COST_CD = E.LGS_COST_CD(+)" ).append("\n"); 

	}
}