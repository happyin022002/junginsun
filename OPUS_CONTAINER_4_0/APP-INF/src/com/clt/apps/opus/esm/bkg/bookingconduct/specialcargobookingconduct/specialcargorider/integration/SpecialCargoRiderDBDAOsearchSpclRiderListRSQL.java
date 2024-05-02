/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : SpecialCargoRiderDBDAOsearchSpclRiderListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.03.12
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2014.03.12 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author BOBAE KIM
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class SpecialCargoRiderDBDAOsearchSpclRiderListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * b/l의 SpclRider image 정보 list를 조회함
	  * </pre>
	  */
	public SpecialCargoRiderDBDAOsearchSpclRiderListRSQL(){
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
		params.put("ridr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.integration").append("\n"); 
		query.append("FileName : SpecialCargoRiderDBDAOsearchSpclRiderListRSQL").append("\n"); 
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
		query.append("#if (${ridr_tp_cd} == 'D') " ).append("\n"); 
		query.append("----  DCGO_SEQ" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",RIDR_TP_CD" ).append("\n"); 
		query.append(",FILE_NM" ).append("\n"); 
		query.append(",FILE_SIZE" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append(",(SELECT CNTR_NO ||' / '|| CNTR_CGO_SEQ FROM BKG_DG_CGO WHERE BKG_NO=MAIN_TABLE.BKG_NO and DCGO_SEQ = MAIN_TABLE.CARGO_SEQ)  AS CARGO_CONTAIN" ).append("\n"); 
		query.append(",CARGO_CNT" ).append("\n"); 
		query.append(",BKG_JOIN_FNC(CURSOR(SELECT DCGO_SEQ FROM BKG_IMG_STO WHERE  BKG_NO=MAIN_TABLE.BKG_NO AND FILE_SAV_ID=MAIN_TABLE.FILE_SAV_ID AND DCGO_SEQ > 0)) AS DCGO_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        MIN(IMG.BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append("        ,MIN(IMG.RIDR_TP_CD) AS RIDR_TP_CD" ).append("\n"); 
		query.append("        ,MIN(IMG.FILE_NM) AS FILE_NM" ).append("\n"); 
		query.append("        ,MIN(UPLD.FILE_SZ_CAPA) AS FILE_SIZE" ).append("\n"); 
		query.append("        ,MIN(IMG.DCGO_SEQ) AS CARGO_SEQ" ).append("\n"); 
		query.append("        ,IMG.FILE_SAV_ID AS FILE_SAV_ID" ).append("\n"); 
		query.append("        ,COUNT(IMG.FILE_SAV_ID) AS CARGO_CNT" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        BKG_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("    WHERE    IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("        AND IMG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND IMG.RIDR_TP_CD= @[ridr_tp_cd]" ).append("\n"); 
		query.append("    GROUP BY IMG.FILE_SAV_ID" ).append("\n"); 
		query.append(") MAIN_TABLE" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#elseif (${ridr_tp_cd} == 'A') " ).append("\n"); 
		query.append("----  AWK_CGO_SEQ" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",RIDR_TP_CD" ).append("\n"); 
		query.append(",FILE_NM" ).append("\n"); 
		query.append(",FILE_SIZE" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append(",(SELECT CNTR_NO FROM BKG_AWK_CGO WHERE BKG_NO=MAIN_TABLE.BKG_NO and AWK_CGO_SEQ = MAIN_TABLE.CARGO_SEQ)  AS CARGO_CONTAIN" ).append("\n"); 
		query.append(",CARGO_CNT" ).append("\n"); 
		query.append(",BKG_JOIN_FNC(CURSOR(SELECT AWK_CGO_SEQ FROM BKG_IMG_STO WHERE  BKG_NO=MAIN_TABLE.BKG_NO AND FILE_SAV_ID=MAIN_TABLE.FILE_SAV_ID AND AWK_CGO_SEQ > 0)) AS DCGO_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        MIN(IMG.BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append("        ,MIN(IMG.RIDR_TP_CD) AS RIDR_TP_CD" ).append("\n"); 
		query.append("        ,MIN(IMG.FILE_NM) AS FILE_NM" ).append("\n"); 
		query.append("        ,MIN(UPLD.FILE_SZ_CAPA) AS FILE_SIZE" ).append("\n"); 
		query.append("        ,MIN(IMG.AWK_CGO_SEQ) AS CARGO_SEQ" ).append("\n"); 
		query.append("        ,IMG.FILE_SAV_ID AS FILE_SAV_ID" ).append("\n"); 
		query.append("        ,COUNT(IMG.FILE_SAV_ID) AS CARGO_CNT" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        BKG_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("    WHERE    IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID(+)" ).append("\n"); 
		query.append("        AND IMG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND IMG.RIDR_TP_CD= @[ridr_tp_cd]" ).append("\n"); 
		query.append("    GROUP BY IMG.FILE_SAV_ID" ).append("\n"); 
		query.append(") MAIN_TABLE" ).append("\n"); 
		query.append("   " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("SELECT " ).append("\n"); 
		query.append("BKG_NO" ).append("\n"); 
		query.append(",RIDR_TP_CD" ).append("\n"); 
		query.append(",FILE_NM" ).append("\n"); 
		query.append(",FILE_SIZE" ).append("\n"); 
		query.append(",FILE_SAV_ID" ).append("\n"); 
		query.append(",''  AS CARGO_CONTAIN" ).append("\n"); 
		query.append(",CARGO_CNT" ).append("\n"); 
		query.append(",'' AS DCGO_SEQ" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("    SELECT " ).append("\n"); 
		query.append("        MIN(IMG.BKG_NO) AS BKG_NO" ).append("\n"); 
		query.append("        ,MIN(IMG.RIDR_TP_CD) AS RIDR_TP_CD" ).append("\n"); 
		query.append("        ,MIN(IMG.FILE_NM) AS FILE_NM" ).append("\n"); 
		query.append("        ,MIN(UPLD.FILE_SZ_CAPA) AS FILE_SIZE" ).append("\n"); 
		query.append("        ,MIN(IMG.DCGO_SEQ) AS CARGO_SEQ" ).append("\n"); 
		query.append("        ,IMG.FILE_SAV_ID AS FILE_SAV_ID" ).append("\n"); 
		query.append("        ,COUNT(IMG.FILE_SAV_ID) AS CARGO_CNT" ).append("\n"); 
		query.append("    FROM " ).append("\n"); 
		query.append("        BKG_IMG_STO IMG, COM_UPLD_FILE UPLD" ).append("\n"); 
		query.append("    WHERE    IMG.FILE_SAV_ID = UPLD.FILE_SAV_ID" ).append("\n"); 
		query.append("        AND IMG.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("        AND IMG.RIDR_TP_CD= @[ridr_tp_cd]" ).append("\n"); 
		query.append("    GROUP BY IMG.FILE_SAV_ID" ).append("\n"); 
		query.append(") MAIN_TABLE" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}