/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOcheckEtdForAlocRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.23
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2014.01.23 류대영
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author DYRYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOcheckEtdForAlocRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Allocation validation을 위해 ETD가 지났는지 확인한다
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOcheckEtdForAlocRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOcheckEtdForAlocRSQL").append("\n"); 
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
		query.append("select 'Y' FLAG" ).append("\n"); 
		query.append("  from BKG_BOOKING BK" ).append("\n"); 
		query.append(" where (SELECT MIN(VPS_ETD_DT)" ).append("\n"); 
		query.append("          FROM BKG_VVD VVD, VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("         WHERE VVD.VSL_CD           = SKD.VSL_CD" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO       = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD       = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD.POL_CD           = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("           AND VVD.BKG_NO           = BK.BKG_NO" ).append("\n"); 
		query.append("           AND VVD.VSL_PRE_PST_CD IN ('S','T'))" ).append("\n"); 
		query.append("        > (SELECT GLOBALDATE_PKG.TIME_CONV_FNC(BKG_COM_USER_LOC_FNC(B.DOC_USR_ID),SYSDATE, B.POL_CD)" ).append("\n"); 
		query.append("             FROM BKG_BOOKING B" ).append("\n"); 
		query.append("            WHERE B.BKG_NO = BK.BKG_NO)" ).append("\n"); 
		query.append("   AND (BK.POL_CD LIKE 'US%' OR BK.POL_CD LIKE 'CA%')" ).append("\n"); 
		query.append("   AND BK.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}