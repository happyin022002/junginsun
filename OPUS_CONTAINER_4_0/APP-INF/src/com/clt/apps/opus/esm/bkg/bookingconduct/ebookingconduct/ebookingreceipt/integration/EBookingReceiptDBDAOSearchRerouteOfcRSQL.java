/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EBookingReceiptDBDAOSearchRerouteOfcRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.10.14
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2015.10.14 이도형
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author LEE, do hyoung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EBookingReceiptDBDAOSearchRerouteOfcRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EBookingReceiptDBDAOSearchRerouteOfcRSQL
	  * </pre>
	  */
	public EBookingReceiptDBDAOSearchRerouteOfcRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ofc_eng_nm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("hndl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.integration").append("\n"); 
		query.append("FileName : EBookingReceiptDBDAOSearchRerouteOfcRSQL").append("\n"); 
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
		query.append("SELECT ESVC.HNDL_OFC_CD" ).append("\n"); 
		query.append("     , MO.OFC_ENG_NM" ).append("\n"); 
		query.append("     , ESVC.BKG_NTFC_EML" ).append("\n"); 
		query.append("     , ESVC.SI_NTFC_EML" ).append("\n"); 
		query.append("     , GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL',SYSDATE,(SELECT MO.LOC_CD FROM COM_USER CU, MDM_ORGANIZATION MO WHERE CU.USR_ID = @[usr_id] AND CU.OFC_CD = MO.OFC_CD)) AS ACT_DT" ).append("\n"); 
		query.append("  FROM BKG_ESVC_OFC_EML ESVC" ).append("\n"); 
		query.append("     , MDM_ORGANIZATION MO" ).append("\n"); 
		query.append(" WHERE ESVC.HNDL_OFC_CD = MO.OFC_CD" ).append("\n"); 
		query.append("#if (${hndl_ofc_cd} != '')" ).append("\n"); 
		query.append("  AND MO.OFC_CD LIKE @[hndl_ofc_cd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ofc_eng_nm} != '')" ).append("\n"); 
		query.append("  AND MO.OFC_ENG_NM LIKE '%'||@[ofc_eng_nm]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY ESVC.HNDL_OFC_CD" ).append("\n"); 

	}
}