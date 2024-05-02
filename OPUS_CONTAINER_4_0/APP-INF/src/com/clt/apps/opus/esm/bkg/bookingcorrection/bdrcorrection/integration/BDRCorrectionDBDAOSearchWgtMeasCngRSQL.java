/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchWgtMeasCngRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.05.25
*@LastModifier : 
*@LastVersion : 1.0
* 2010.05.25 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchWgtMeasCngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearchWgtMeasCngRSQL
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchWgtMeasCngRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchWgtMeasCngRSQL").append("\n"); 
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
		query.append("SELECT MAX(WGTMEASCNG) WGT_MEAS_CNG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') WGTMEASCNG" ).append("\n"); 
		query.append("FROM BKG_BL_DOC     BBD" ).append("\n"); 
		query.append(", BKG_BL_DOC_HIS BBDH" ).append("\n"); 
		query.append("WHERE BBD.BKG_NO   = BBDH.BKG_NO" ).append("\n"); 
		query.append("AND BBDH.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND BBD.BKG_NO   = @[bkg_no]" ).append("\n"); 
		query.append("AND ( BBD.MEAS_QTY   != BBDH.MEAS_QTY" ).append("\n"); 
		query.append("OR BBD.ACT_WGT    != BBDH.ACT_WGT )" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') WGTMEASCNG" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NEW.CNTR_WGT NCNTR_WGT, NEW.MEAS_QTY NMEAS_QTY," ).append("\n"); 
		query.append("OLD.CNTR_WGT OCNTR_WGT, OLD.MEAS_QTY OMEAS_QTY" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("SELECT NVL(CNTR_NO,' ') CNTR_NO, NVL(CNTR_WGT,0) CNTR_WGT," ).append("\n"); 
		query.append("NVL(MEAS_QTY,0) MEAS_QTY" ).append("\n"); 
		query.append("FROM BKG_CNTR_HIS" ).append("\n"); 
		query.append("WHERE BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append("AND CORR_NO         = 'TMP0000001'" ).append("\n"); 
		query.append(") NEW FULL OUTER JOIN" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT NVL(CNTR_NO,' ') CNTR_NO, NVL(CNTR_WGT,0) CNTR_WGT," ).append("\n"); 
		query.append("NVL(MEAS_QTY,0) MEAS_QTY" ).append("\n"); 
		query.append("FROM BKG_CONTAINER BCRH" ).append("\n"); 
		query.append("WHERE BKG_NO          = @[bkg_no]" ).append("\n"); 
		query.append(") OLD" ).append("\n"); 
		query.append("ON NVL(NEW.CNTR_NO,' ') = NVL(OLD.CNTR_NO,' ') )" ).append("\n"); 
		query.append("WHERE NVL(NCNTR_WGT,0) <> NVL(OCNTR_WGT,0)" ).append("\n"); 
		query.append("OR NVL(NMEAS_QTY,0) <> NVL(OMEAS_QTY,0)" ).append("\n"); 
		query.append(")" ).append("\n"); 

	}
}