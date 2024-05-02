/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : UnmatchBLDBDAOCheckOihDihRatAsQtyRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.26
*@LastModifier : 
*@LastVersion : 1.0
* 2015.01.26 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UnmatchBLDBDAOCheckOihDihRatAsQtyRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * India지역 AutoRating 후 OIH, DIH Manual 입력시 Rate As Qty를 제대로 입력했는지 여부 판단
	  * </pre>
	  */
	public UnmatchBLDBDAOCheckOihDihRatAsQtyRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ca_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.revenueaudit.unmatchbl.integration").append("\n"); 
		query.append("FileName : UnmatchBLDBDAOCheckOihDihRatAsQtyRSQL").append("\n"); 
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
		query.append("SELECT  DECODE(" ).append("\n"); 
		query.append("            DECODE(OFT_RAT_AS_QTY1, NVL(OIH_RAT_AS_QTY1,OFT_RAT_AS_QTY1), 0, 1) +" ).append("\n"); 
		query.append("            DECODE(OFT_RAT_AS_QTY1, NVL(DIH_RAT_AS_QTY1,OFT_RAT_AS_QTY1), 0, 1) +" ).append("\n"); 
		query.append("            DECODE(OFT_RAT_AS_QTY2, NVL(OIH_RAT_AS_QTY2,OFT_RAT_AS_QTY2), 0, 1) +" ).append("\n"); 
		query.append("            DECODE(OFT_RAT_AS_QTY2, NVL(DIH_RAT_AS_QTY2,OFT_RAT_AS_QTY2), 0, 1) , 0, 'Y', 'N') IH_PASS" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT  SUM(NVL(RAT_AS_QTY,0))" ).append("\n"); 
		query.append("            FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("            WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("            AND     @[ca_flg]     = 'N'" ).append("\n"); 
		query.append("            AND     CHG_CD = 'OFT'" ).append("\n"); 
		query.append("           ) OFT_RAT_AS_QTY1," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT  SUM(NVL(RAT_AS_QTY,0))" ).append("\n"); 
		query.append("            FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("            WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("            AND     @[ca_flg]     = 'N'" ).append("\n"); 
		query.append("            AND     CHG_CD = 'OIH'" ).append("\n"); 
		query.append("           ) OIH_RAT_AS_QTY1," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT  SUM(NVL(RAT_AS_QTY,0))" ).append("\n"); 
		query.append("            FROM    BKG_CHG_RT" ).append("\n"); 
		query.append("            WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("            AND     @[ca_flg]     = 'N'" ).append("\n"); 
		query.append("            AND     CHG_CD = 'DIH'" ).append("\n"); 
		query.append("           ) DIH_RAT_AS_QTY1," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT  SUM(NVL(RAT_AS_QTY,0))" ).append("\n"); 
		query.append("            FROM    BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("            WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("            AND     CORR_NO       = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("            AND     @[ca_flg]     = 'Y'" ).append("\n"); 
		query.append("            AND     CHG_CD = 'OFT'" ).append("\n"); 
		query.append("           ) OFT_RAT_AS_QTY2," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT  SUM(NVL(RAT_AS_QTY,0))" ).append("\n"); 
		query.append("            FROM    BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("            WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("            AND     CORR_NO       = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("            AND     @[ca_flg]     = 'Y'" ).append("\n"); 
		query.append("            AND     CHG_CD = 'OIH'" ).append("\n"); 
		query.append("           ) OIH_RAT_AS_QTY2," ).append("\n"); 
		query.append("           (" ).append("\n"); 
		query.append("            SELECT  SUM(NVL(RAT_AS_QTY,0))" ).append("\n"); 
		query.append("            FROM    BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("            WHERE   BKG_NO        = @[bkg_no]" ).append("\n"); 
		query.append("            AND     CORR_NO       = 'TMP0000001'  -- CORRECTION 중인 DATA 를 나타내는 고정된 상수값" ).append("\n"); 
		query.append("            AND     @[ca_flg]     = 'Y'" ).append("\n"); 
		query.append("            AND     CHG_CD = 'DIH'" ).append("\n"); 
		query.append("           ) DIH_RAT_AS_QTY2" ).append("\n"); 
		query.append("    FROM   DUAL" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}