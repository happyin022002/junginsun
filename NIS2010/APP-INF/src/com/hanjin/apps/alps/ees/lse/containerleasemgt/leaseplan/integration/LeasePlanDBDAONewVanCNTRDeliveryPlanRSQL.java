/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.15
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.04.15 장준우
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jang Jun-Woo
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class LeasePlanDBDAONewVanCNTRDeliveryPlanRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 신조장비(OW/LP/OL) 계획내용의 존재여부를 확인한다.
	  * </pre>
	  */
	public LeasePlanDBDAONewVanCNTRDeliveryPlanRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mft_vndr_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("de_qty",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cntr_tpsz_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.NUMERIC + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("pln_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("lstm_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("new_van_yrmon",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("agmt_cty_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.ees.lse.containerleasemgt.leaseplan.integration").append("\n"); 
		query.append("FileName : LeasePlanDBDAONewVanCNTRDeliveryPlanRSQL").append("\n"); 
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
		query.append("SELECT	A.PLN_YRMON," ).append("\n"); 
		query.append("		A.NEW_VAN_YRMON," ).append("\n"); 
		query.append("		A.MFT_VNDR_SEQ," ).append("\n"); 
		query.append("		A.DEL_CD," ).append("\n"); 
		query.append("		A.CNTR_TPSZ_CD," ).append("\n"); 
		query.append("		A.AGMT_CTY_CD," ).append("\n"); 
		query.append("		A.AGMT_SEQ," ).append("\n"); 
		query.append("		A.LSTM_CD," ).append("\n"); 
		query.append("		A.DE_QTY," ).append("\n"); 
		query.append("		A.CRE_USR_ID," ).append("\n"); 
		query.append("		A.CRE_DT," ).append("\n"); 
		query.append("		A.UPD_USR_ID," ).append("\n"); 
		query.append("		A.UPD_DT," ).append("\n"); 
		query.append("		A.PLN_RMK" ).append("\n"); 
		query.append("FROM	LSE_NEW_VAN_DE_PLN A" ).append("\n"); 
		query.append("WHERE	1 = 1" ).append("\n"); 
		query.append("#if (${pln_yrmon} != '')" ).append("\n"); 
		query.append("AND 	A.PLN_YRMON = @[pln_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${new_van_yrmon} != '')" ).append("\n"); 
		query.append("AND 	A.NEW_VAN_YRMON = @[new_van_yrmon]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${mft_vndr_seq} != '')" ).append("\n"); 
		query.append("AND 	A.MFT_VNDR_SEQ = @[mft_vndr_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${del_cd} != '')" ).append("\n"); 
		query.append("AND 	A.DEL_CD = @[del_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${cntr_tpsz_cd} != '')" ).append("\n"); 
		query.append("AND 	A.CNTR_TPSZ_CD = @[cntr_tpsz_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_cty_cd} != '')" ).append("\n"); 
		query.append("AND     A.AGMT_CTY_CD = @[agmt_cty_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${agmt_seq} != '')" ).append("\n"); 
		query.append("AND     A.AGMT_SEQ = @[agmt_seq]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${lstm_cd} != '')" ).append("\n"); 
		query.append("AND     A.LSTM_CD = @[lstm_cd]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${de_qty} != '')" ).append("\n"); 
		query.append("AND     A.DE_QTY = @[de_qty]" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}