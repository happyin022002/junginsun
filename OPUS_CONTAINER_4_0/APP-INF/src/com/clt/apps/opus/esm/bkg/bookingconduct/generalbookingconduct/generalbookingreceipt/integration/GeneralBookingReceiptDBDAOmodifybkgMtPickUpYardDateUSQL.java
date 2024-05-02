/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOmodifybkgMtPickUpYardDateUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.19
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.04.19 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOmodifybkgMtPickUpYardDateUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * modify Empty Pick Up Yard and Date as like Prd information
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOmodifybkgMtPickUpYardDateUSQL(){
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
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOmodifybkgMtPickUpYardDateUSQL").append("\n"); 
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
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("UPDATE BKG_BKG_HIS SET" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("UPDATE BKG_BOOKING SET" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("(MTY_PKUP_YD_CD, MTY_PKUP_DT,FULL_RTN_YD_CD, UPD_USR_ID, UPD_DT ) = " ).append("\n"); 
		query.append("(SELECT NVL(MTY_PKUP_YD_CD,'') MTY_PKUP_YD_CD" ).append("\n"); 
		query.append("	  , CASE WHEN MST.MTY_PKUP_YD_CD is null THEN TO_DATE('', 'YYYY-MM-DD HH24:MI:SS') ELSE NVL(DTL.ARR_ST_DT,'') END MTY_PKUP_DT" ).append("\n"); 
		query.append("      , MST.FULL_RTN_YD_CD FULL_RTN_YD_CD" ).append("\n"); 
		query.append("	  , @[usr_id] UPD_USR_ID" ).append("\n"); 
		query.append("	  , SYSDATE UPD_DT" ).append("\n"); 
		query.append("   FROM PRD_PROD_CTL_MST MST, PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("  WHERE 1=1 " ).append("\n"); 
		query.append("    AND MST.PCTL_NO = (SELECT PCTL_NO FROM BKG_BOOKING WHERE BKG_NO = @[bkg_no])" ).append("\n"); 
		query.append("    AND MST.PCTL_NO = DTL.PCTL_NO" ).append("\n"); 
		query.append("    AND DTL.PCTL_SEQ = 1)" ).append("\n"); 
		query.append(" WHERE BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}