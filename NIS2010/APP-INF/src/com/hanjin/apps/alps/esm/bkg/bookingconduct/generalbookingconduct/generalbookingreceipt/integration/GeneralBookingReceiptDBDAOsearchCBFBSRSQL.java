/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOsearchCBFBSRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.04
*@LastModifier : 
*@LastVersion : 1.0
* 2010.11.04 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOsearchCBFBSRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCBFBS
	  * 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOsearchCBFBSRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("yd_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("skd_voy_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vsl_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOsearchCBFBSRSQL").append("\n"); 
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
		query.append("SELECT T.CBF_IND_FLG," ).append("\n"); 
		query.append("T.CBF_BKG_STS_CD," ).append("\n"); 
		query.append("T.UPD_USR_ID," ).append("\n"); 
		query.append("T.UPD_DT" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT DECODE(CBF_IND_FLG,'P','Pre','F','Final','null') CBF_IND_FLG," ).append("\n"); 
		query.append("DECODE(CBF_BKG_STS_CD,'','All','F','Firm','null') CBF_BKG_STS_CD," ).append("\n"); 
		query.append("UPD_USR_ID," ).append("\n"); 
		query.append("TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRPUS',UPD_DT,'GMT'), 'YYYY-MM-DD HH24:MI') UPD_DT" ).append("\n"); 
		query.append("FROM OPF_CGO_BKG_FCAST" ).append("\n"); 
		query.append("WHERE VSL_CD                  = @[vsl_cd]" ).append("\n"); 
		query.append("AND SKD_VOY_NO              = @[skd_voy_no]" ).append("\n"); 
		query.append("AND SKD_DIR_CD              = @[skd_dir_cd]" ).append("\n"); 
		query.append("AND YD_CD||POL_CLPT_IND_SEQ = @[yd_cd]" ).append("\n"); 
		query.append("ORDER BY DECODE(BKG_SHPR_OWNR_FLG,'Y',1,2), UPD_DT DESC" ).append("\n"); 
		query.append(") T" ).append("\n"); 
		query.append("WHERE ROWNUM = 1" ).append("\n"); 

	}
}