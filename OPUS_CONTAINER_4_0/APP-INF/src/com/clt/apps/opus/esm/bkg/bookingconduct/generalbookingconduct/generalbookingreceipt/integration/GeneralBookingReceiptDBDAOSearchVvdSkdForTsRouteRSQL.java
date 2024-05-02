/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchVvdSkdForTsRouteRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.01.04
*@LastModifier : 류대영
*@LastVersion : 1.0
* 2010.01.04 류대영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Dae-Young RYU
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchVvdSkdForTsRouteRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TS Route에서 VVD 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchVvdSkdForTsRouteRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchVvdSkdForTsRouteRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",	VSL_PRE_PST_CD" ).append("\n"); 
		query.append(",	VSL_SEQ" ).append("\n"); 
		query.append(",	SLAN_CD" ).append("\n"); 
		query.append(",	VSL_CD" ).append("\n"); 
		query.append(",	SKD_VOY_NO" ).append("\n"); 
		query.append(",	SKD_DIR_CD" ).append("\n"); 
		query.append(",   VSL_CD||SKD_VOY_NO||SKD_DIR_CD BKG_VVD_CD" ).append("\n"); 
		query.append(",   POL_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",   POD_CLPT_IND_SEQ" ).append("\n"); 
		query.append(",	OP_CD" ).append("\n"); 
		query.append(",	POL_CD" ).append("\n"); 
		query.append(",	SUBSTR(POL_YD_CD,6,2) POL_YD_CD" ).append("\n"); 
		query.append(",	POD_CD" ).append("\n"); 
		query.append(",	SUBSTR(POD_YD_CD,6,2) POD_YD_CD" ).append("\n"); 
		query.append(",	BKG_TRSP_MZD_CD" ).append("\n"); 
		query.append(",	CNTR_LODG_FLG" ).append("\n"); 
		query.append(",	REV_VVD_FLG" ).append("\n"); 
		query.append(",	CRE_USR_ID" ).append("\n"); 
		query.append(",	CRE_DT" ).append("\n"); 
		query.append(",	UPD_USR_ID" ).append("\n"); 
		query.append(",	UPD_DT" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("FROM BKG_VVD_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE	BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("ORDER BY BKG_NO, VSL_PRE_PST_CD, VSL_SEQ" ).append("\n"); 

	}
}