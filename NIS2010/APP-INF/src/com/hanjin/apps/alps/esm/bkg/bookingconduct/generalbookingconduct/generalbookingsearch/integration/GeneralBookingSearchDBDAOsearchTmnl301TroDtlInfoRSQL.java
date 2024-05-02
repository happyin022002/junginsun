/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOsearchTmnl301TroDtlInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.06.28
*@LastModifier : 
*@LastVersion : 1.0
* 2018.06.28 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOsearchTmnl301TroDtlInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchTmnl301TroDtlInfo
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOsearchTmnl301TroDtlInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOsearchTmnl301TroDtlInfoRSQL").append("\n"); 
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
		query.append("SELECT '{TRO_DTL_OUT'																			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_SEQ:'				|| LPAD(TRO_SEQ, 2, '0')										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_DOOR_DT:'   		|| NVL(TO_CHAR(DOR_ARR_DT, 'RRRRMMDDHH24'), ' ')				|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_CNTRTS_CD:' 		|| CNTR_TPSZ_CD													|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_QTY:'       		|| TRUNC(NVL(TRO_QTY, '0'))										|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_PICKUP_CY:' 		|| SUBSTR(NVL(PKUP_YD_CD, '     '), 3, 5)			 			|| CHR(10)" ).append("\n"); 
		query.append("	|| 'TRO_RETURN_CY:' 		|| SUBSTR(NVL(RTN_YD_CD,  '     '), 3, 5)						|| CHR(10)" ).append("\n"); 
		query.append("	|| '}TRO_DTL_OUT'		   	|| CHR(10) TRO_DTL_INFO" ).append("\n"); 
		query.append("  FROM BKG_TRO_DTL" ).append("\n"); 
		query.append(" WHERE BKG_NO 				= @[bkg_no]" ).append("\n"); 
		query.append("   AND TRO_SEQ				= @[tro_seq]" ).append("\n"); 
		query.append("   AND IO_BND_CD      		= 'O'" ).append("\n"); 
		query.append("   AND CXL_FLG              = 'N'" ).append("\n"); 
		query.append("   AND CNTR_TPSZ_CD IN (SELECT DISTINCT CNTR_TPSZ_CD " ).append("\n"); 
		query.append("						FROM   BKG_QUANTITY " ).append("\n"); 
		query.append("						WHERE  BKG_NO = @[bkg_no])" ).append("\n"); 

	}
}