/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BDRCorrectionDBDAOCheckPrnHdnFlgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2012.09.27
*@LastModifier : 조정민
*@LastVersion : 1.0
* 2012.09.27 조정민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author JEONGMINCHO
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BDRCorrectionDBDAOCheckPrnHdnFlgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Charge Hidden flag 변경시 면제가능한지 확인한다.
	  * </pre>
	  */
	public BDRCorrectionDBDAOCheckPrnHdnFlgRSQL(){
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
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.bdrcorrection.integration ").append("\n"); 
		query.append("FileName : BDRCorrectionDBDAOCheckPrnHdnFlgRSQL").append("\n"); 
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
		query.append("  FROM BKG_CHG_RT     RATE" ).append("\n"); 
		query.append("      ,BKG_CHG_RT_HIS RTHIS" ).append("\n"); 
		query.append(" WHERE RTHIS.BKG_NO  = @[bkg_no]" ).append("\n"); 
		query.append("   AND RTHIS.CORR_NO = 'TMP0000001' " ).append("\n"); 
		query.append("   AND RTHIS.BKG_NO  = RATE.BKG_NO" ).append("\n"); 
		query.append("   AND RTHIS.RT_SEQ  = RATE.RT_SEQ" ).append("\n"); 
		query.append("   AND NVL(RTHIS.PRN_HDN_FLG, '*') <> NVL(RATE.PRN_HDN_FLG, '*')" ).append("\n"); 

	}
}