/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BDRCorrectionDBDAOSearch3thPtyOfcCdCngRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.11.10
*@LastModifier : 신자영
*@LastVersion : 1.0
* 2010.11.10 
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

public class BDRCorrectionDBDAOSearch3thPtyOfcCdCngRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BDRCorrectionDBDAOSearch3thPtyOfcCdCngRSQL
	  * Charge화면에서 입력하는 3th party office변경 여부 check
	  * 2010.11.05 신자영 [CHM-201006646-01] C/A Exemption 하드코딩 Case추가건(2)
	  * </pre>
	  */
	public BDRCorrectionDBDAOSearch3thPtyOfcCdCngRSQL(){
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
		query.append("FileName : BDRCorrectionDBDAOSearch3thPtyOfcCdCngRSQL").append("\n"); 
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
		query.append("SELECT NVL(DECODE(COUNT(*), 0, 'N', 'Y'), 'N') CHN_FLG" ).append("\n"); 
		query.append("FROM BKG_CHG_RT     RATE" ).append("\n"); 
		query.append(", BKG_CHG_RT_HIS RTHIS" ).append("\n"); 
		query.append("WHERE RTHIS.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("AND RTHIS.CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("AND RTHIS.BKG_NO  = RATE.BKG_NO" ).append("\n"); 
		query.append("AND RTHIS.RT_SEQ  = RATE.RT_SEQ" ).append("\n"); 
		query.append("AND NVL(RTHIS.N3PTY_RCV_OFC_CD, '*') <> NVL(RATE.N3PTY_RCV_OFC_CD, '*')" ).append("\n"); 

	}
}