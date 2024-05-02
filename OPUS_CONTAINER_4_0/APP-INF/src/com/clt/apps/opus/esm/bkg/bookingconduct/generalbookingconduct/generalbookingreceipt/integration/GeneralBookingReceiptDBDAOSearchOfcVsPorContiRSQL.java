/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchOfcVsPorContiRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.01
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.04.01 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Ryu Daeyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchOfcVsPorContiRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 다른 대륙의 Booking을 생성할 수 없음
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchOfcVsPorContiRSQL(){
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
		params.put("por_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchOfcVsPorContiRSQL").append("\n"); 
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
		query.append("SELECT COUNT(*) CNT" ).append("\n"); 
		query.append("FROM MDM_ORGANIZATION OFC" ).append("\n"); 
		query.append(", MDM_LOCATION OFC_LOC" ).append("\n"); 
		query.append(", MDM_LOCATION POR" ).append("\n"); 
		query.append("WHERE OFC.OFC_CD   = @[ofc_cd]" ).append("\n"); 
		query.append("AND OFC.LOC_CD   = OFC_LOC.LOC_CD" ).append("\n"); 
		query.append("AND POR.LOC_CD   = @[por_cd]" ).append("\n"); 
		query.append("AND POR.CONTI_CD <> CASE WHEN NVL((SELECT 'Y'" ).append("\n"); 
		query.append("FROM COM_USR_ROLE_MTCH" ).append("\n"); 
		query.append("WHERE USR_ROLE_CD IN ('BKG16','BKG17')--DOC CENTER는 대륙 CODE가 같아도 가능" ).append("\n"); 
		query.append("AND USR_ID = @[usr_id]" ).append("\n"); 
		query.append("AND ROWNUM = 1), 'N') = 'Y' THEN POR.CONTI_CD" ).append("\n"); 
		query.append("ELSE OFC_LOC.CONTI_CD END" ).append("\n"); 
		query.append("AND ROWNUM = 1" ).append("\n"); 

	}
}