/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearchObsChgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.07.07
*@LastModifier : 
*@LastVersion : 1.0
* 2011.07.07 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOSearchObsChgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchObsChg
	  * 2011.07.07 이일민 [CHM-201111747] C/A Exemption 항목에 VDT 추가
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearchObsChgRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOSearchObsChgRSQL").append("\n"); 
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
		query.append("#if ('Y'==${ca_flg})" ).append("\n"); 
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') AS OBS_FLG" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT_HIS" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND    CHG_CD = 'OBS'" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') AS OBS_FLG" ).append("\n"); 
		query.append("FROM   BKG_CHG_RT" ).append("\n"); 
		query.append("WHERE  BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND    CHG_CD = 'OBS'" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}