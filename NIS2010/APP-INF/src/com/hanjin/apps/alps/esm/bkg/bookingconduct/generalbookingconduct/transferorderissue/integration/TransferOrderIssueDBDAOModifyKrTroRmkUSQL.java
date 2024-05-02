/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : TransferOrderIssueDBDAOModifyKrTroRmkUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.27
*@LastModifier : 윤태승
*@LastVersion : 1.0
* 2011.10.27 윤태승
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author yuntaeseung
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class TransferOrderIssueDBDAOModifyKrTroRmkUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * TransferOrderIssueDBDAOModifyKrTroRmk
	  * * 2011.10.27 윤태승 [CHM-201113981-01]ALPS > Booking Creation > TRO/O remarks 에 문구 삽입 요청드립니다.
	  * </pre>
	  */
	public TransferOrderIssueDBDAOModifyKrTroRmkUSQL(){
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
		params.put("tro_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rtn_tro_flg",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.integration").append("\n"); 
		query.append("FileName : TransferOrderIssueDBDAOModifyKrTroRmkUSQL").append("\n"); 
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
		query.append("UPDATE /*+ BYPASS_UJVC */" ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("SELECT INSTR(B.DIFF_RMK, '위 BKG의 D2 장비에 대해 5년 이하의 신규 장비 공급 바랍니다.', 1, 1) AS POS" ).append("\n"); 
		query.append(",B.DIFF_RMK" ).append("\n"); 
		query.append("FROM BKG_BOOKING A" ).append("\n"); 
		query.append(",BKG_TRO B" ).append("\n"); 
		query.append(",BKG_TRO_DTL C" ).append("\n"); 
		query.append("WHERE A.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND A.SLAN_CD = 'ALX'" ).append("\n"); 
		query.append("AND A.SKD_DIR_CD = 'W'" ).append("\n"); 
		query.append("AND A.POL_CD = 'KRPUS'" ).append("\n"); 
		query.append("AND A.POD_CD IN ('BRSSZ','BRRIG', 'ARBUE')" ).append("\n"); 
		query.append("AND A.BKG_NO = B.BKG_NO" ).append("\n"); 
		query.append("AND B.IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND B.RTN_TRO_FLG = @[rtn_tro_flg]" ).append("\n"); 
		query.append("AND B.TRO_SEQ = @[tro_seq]" ).append("\n"); 
		query.append("AND B.BKG_NO = C.BKG_NO" ).append("\n"); 
		query.append("AND B.IO_BND_CD = C.IO_BND_CD" ).append("\n"); 
		query.append("AND B.RTN_TRO_FLG = C.RTN_TRO_FLG" ).append("\n"); 
		query.append("AND B.TRO_SEQ = C.TRO_SEQ" ).append("\n"); 
		query.append("AND C.CNTR_TPSZ_CD = 'D2'" ).append("\n"); 
		query.append("AND C.CXL_FLG = 'N'" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("SET  DIFF_RMK =  DIFF_RMK || ' 위 BKG의 D2 장비에 대해 5년 이하의 신규 장비 공급 바랍니다.'" ).append("\n"); 
		query.append("WHERE POS IS NULL" ).append("\n"); 
		query.append("OR POS = 0" ).append("\n"); 

	}
}