/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchConstraintRSQL.java
*@FileTitle : Container Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.16
*@LastModifier : 김병규
*@LastVersion : 1.0
* 2009.07.16 김병규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kim Byung Kyu
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchConstraintRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  *    
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchConstraintRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchConstraintRSQL").append("\n"); 
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
		query.append("SELECT  BKG.SLAN_CD" ).append("\n"); 
		query.append(",BKG.POL_CD" ).append("\n"); 
		query.append(",CNST.TRNK_LANE_CD" ).append("\n"); 
		query.append(",CNST.N1ST_LANE_CD" ).append("\n"); 
		query.append(",CNST.N1ST_TS_PORT_CD" ).append("\n"); 
		query.append(",CNST.N2ND_LANE_CD" ).append("\n"); 
		query.append(",CNST.N2ND_TS_PORT_CD" ).append("\n"); 
		query.append(",BKG.POD_CD" ).append("\n"); 
		query.append(",SUBSTR(BKG.POD_NOD_CD,5,2) POD_NOD_CD" ).append("\n"); 
		query.append(",BKG.DEL_CD" ).append("\n"); 
		query.append(",CNST.ROUT_CNST_RMK" ).append("\n"); 
		query.append("FROM    BKG_BOOKING BKG" ).append("\n"); 
		query.append(",SCE_COP_HDR COP" ).append("\n"); 
		query.append(",PRD_PROD_CTL_MST PRD" ).append("\n"); 
		query.append(",PRD_ROUT_CNST CNST" ).append("\n"); 
		query.append("WHERE   BKG.BKG_NO = COP.BKG_NO" ).append("\n"); 
		query.append("AND     COP.PCTL_NO = PRD.PCTL_NO" ).append("\n"); 
		query.append("AND     PRD.ROUT_CNST_SEQ = CNST.ROUT_CNST_SEQ" ).append("\n"); 
		query.append("AND     BKG.SLAN_CD = CNST.TRNK_LANE_CD" ).append("\n"); 
		query.append("AND     BKG.POL_NOD_CD = CNST.POL_NOD_CD" ).append("\n"); 
		query.append("AND     BKG.POD_NOD_CD = CNST.POD_NOD_CD" ).append("\n"); 
		query.append("AND     BKG.DEL_CD = CNST.DEL_CD" ).append("\n"); 
		query.append("AND     CNST.DELT_FLG = 'N'" ).append("\n"); 
		query.append("AND     BKG.BKG_NO = @[bkg_no]" ).append("\n"); 

	}
}