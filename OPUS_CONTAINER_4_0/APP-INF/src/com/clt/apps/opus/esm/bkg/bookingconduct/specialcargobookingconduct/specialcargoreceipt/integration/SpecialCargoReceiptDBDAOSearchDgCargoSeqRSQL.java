/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : SpecialCargoReceiptDBDAOSearchDgCargoSeqRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.12.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.12.16 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoReceiptDBDAOSearchDgCargoSeqRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG_NO, DCGO_SEQ 에 대한 BKG_DG_CGO 또는 BKG_DG_CGO_HIS의 데이터 존재여부 체크 로직
	  * </pre>
	  */
	public SpecialCargoReceiptDBDAOSearchDgCargoSeqRSQL(){
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

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dcgo_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.integration ").append("\n"); 
		query.append("FileName : SpecialCargoReceiptDBDAOSearchDgCargoSeqRSQL").append("\n"); 
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
		query.append("SELECT CASE WHEN COUNT(*) > 0 THEN 'Y' " ).append("\n"); 
		query.append("       ELSE 'N' " ).append("\n"); 
		query.append("       END DCGO_YN" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("FROM BKG_DG_CGO_HIS" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("FROM BKG_DG_CGO" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("#if (${ca_flg} == 'Y')" ).append("\n"); 
		query.append("AND CORR_NO = 'TMP0000001'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("AND DCGO_SEQ = @[dcgo_seq]" ).append("\n"); 

	}
}