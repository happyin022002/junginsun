/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchOldBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.04.22
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.04.22 정인선
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

public class GeneralBookingReceiptDBDAOSearchOldBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 수정전 Booking 정보 조회
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchOldBkgInfoRSQL(){
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
		query.append("FileName : GeneralBookingReceiptDBDAOSearchOldBkgInfoRSQL").append("\n"); 
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
		query.append("select " ).append("\n"); 
		query.append("        RCV_TERM_CD, " ).append("\n"); 
		query.append("        DE_TERM_CD, " ).append("\n"); 
		query.append("        BKG_CGO_TP_CD," ).append("\n"); 
		query.append("        OB_SLS_OFC_CD," ).append("\n"); 
		query.append("		SLAN_CD," ).append("\n"); 
		query.append("        VSL_CD||SKD_VOY_NO||SKD_DIR_CD BKG_TRUNK_VVD," ).append("\n"); 
		query.append("        (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("                    FRIST_VVD" ).append("\n"); 
		query.append("            FROM    (" ).append("\n"); 
		query.append("                        SELECT  VSL_CD||SKD_VOY_NO||SKD_DIR_CD FRIST_VVD" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("                        FROM    BKG_VVD_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                        FROM    BKG_VVD" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("						AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("                        ORDER BY VSL_PRE_PST_CD,VSL_SEQ " ).append("\n"); 
		query.append("                    )" ).append("\n"); 
		query.append("            WHERE     ROWNUM = 1 " ).append("\n"); 
		query.append("        ) FIRST_VVD," ).append("\n"); 
		query.append("        POR_CD, " ).append("\n"); 
		query.append("        POR_NOD_CD, " ).append("\n"); 
		query.append("        POL_CD, " ).append("\n"); 
		query.append("        POL_NOD_CD," ).append("\n"); 
		query.append("        POD_CD, " ).append("\n"); 
		query.append("        POD_NOD_CD, " ).append("\n"); 
		query.append("        DEL_CD, " ).append("\n"); 
		query.append("        DEL_NOD_CD, " ).append("\n"); 
		query.append("        PRE_RLY_PORT_CD, " ).append("\n"); 
		query.append("        PST_RLY_PORT_CD," ).append("\n"); 
		query.append("        MTY_PKUP_YD_CD, " ).append("\n"); 
		query.append("        FULL_RTN_YD_CD," ).append("\n"); 
		query.append("		PCTL_NO," ).append("\n"); 
		query.append("		BKG_CTRL_PTY_CUST_CNT_CD," ).append("\n"); 
		query.append("		BKG_CTRL_PTY_CUST_SEQ" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("FROM    BKG_BKG_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM    BKG_BOOKING" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE   BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg}== 'Y')" ).append("\n"); 
		query.append("AND   CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}