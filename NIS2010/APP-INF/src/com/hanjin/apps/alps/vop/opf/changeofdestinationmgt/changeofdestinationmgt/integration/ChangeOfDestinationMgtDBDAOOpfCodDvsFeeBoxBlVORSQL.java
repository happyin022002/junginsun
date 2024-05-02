/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeBoxBlVORSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.02.16
*@LastModifier : 
*@LastVersion : 1.0
* 2015.02.16 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ChangeOfDestinationMgtDBDAOOpfCodDvsFeeBoxBlVORSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * COD Tariff Registration 팝업 Calculation 조회 쿼리
	  * 
	  * History
	  * 2015.03.06 이병훈 [CHM-201534196] COD charges DVC 비용 관련 로직 수정
	  * </pre>
	  */
	public ChangeOfDestinationMgtDBDAOOpfCodDvsFeeBoxBlVORSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("curr_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("skd_dir_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cgo_cate_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.vop.opf.changeofdestinationmgt.changeofdestinationmgt.integration").append("\n"); 
		query.append("FileName : ChangeOfDestinationMgtDBDAOOpfCodDvsFeeBoxBlVORSQL").append("\n"); 
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
		query.append("SELECT " ).append("\n"); 
		query.append("'DVC' CHG_CD" ).append("\n"); 
		query.append(", A.CONTI_CD" ).append("\n"); 
		query.append(", A.DVS_FEE_TP_CD" ).append("\n"); 
		query.append(", A.DVS_FEE_AMT" ).append("\n"); 
		query.append(", G.CURR_CD" ).append("\n"); 
		query.append(", A.DVS_FEE_AMT*G.USD_LOCL_XCH_RT AS DVS_FEE_AMT_XCH" ).append("\n"); 
		query.append(", B.DVS_FEE_TP_CD AS DVS_FEE_TP_CD_BOX_BL" ).append("\n"); 
		query.append(", B.DVS_FEE_AMT AS  DVS_FEE_AMT_BOX_BL" ).append("\n"); 
		query.append(", B.DVS_FEE_AMT*G.USD_LOCL_XCH_RT AS DVS_FEE_AMT_BOX_BL_XCH" ).append("\n"); 
		query.append("FROM" ).append("\n"); 
		query.append("OPF_COD_DVS_FEE A," ).append("\n"); 
		query.append("OPF_COD_DVS_FEE B," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT  CASE WHEN POL_CNTT = 'A' AND POD_CNTT = 'A' THEN 'A'" ).append("\n"); 
		query.append("                 WHEN POL_CNTT = 'E' AND POD_CNTT = 'A' THEN 'E'" ).append("\n"); 
		query.append("                 WHEN POL_CNTT = 'A' AND POD_CNTT = 'E' THEN 'E'" ).append("\n"); 
		query.append("                 WHEN POL_CNTT = 'E' AND POD_CNTT = 'M' THEN 'E'" ).append("\n"); 
		query.append("                 WHEN POL_CNTT = 'M' AND POD_CNTT = 'A' THEN 'M'" ).append("\n"); 
		query.append("                 WHEN POL_CNTT = 'A' AND POD_CNTT = 'M' THEN 'M'" ).append("\n"); 
		query.append("                 WHEN POL_CNTT = 'M' AND POD_CNTT = 'E' THEN 'M'                     " ).append("\n"); 
		query.append("				 ELSE 'E'" ).append("\n"); 
		query.append("                 END AS CONTI_CD " ).append("\n"); 
		query.append("    FROM (" ).append("\n"); 
		query.append("            SELECT " ).append("\n"); 
		query.append("             L1.CONTI_CD POL_CNTT" ).append("\n"); 
		query.append("            ,L2.CONTI_CD POD_CNTT" ).append("\n"); 
		query.append("            FROM" ).append("\n"); 
		query.append("            BKG_COD C, " ).append("\n"); 
		query.append("            MDM_LOCATION L1, " ).append("\n"); 
		query.append("            MDM_LOCATION L2" ).append("\n"); 
		query.append("            WHERE  C.BKG_NO            = @[bkg_no]" ).append("\n"); 
		query.append("            AND    C.COD_RQST_SEQ      = @[cod_rqst_seq]" ).append("\n"); 
		query.append("            AND    L1.LOC_CD     = SUBSTR(C.NEW_POL_YD_CD,1,5)" ).append("\n"); 
		query.append("            AND    L2.LOC_CD     = SUBSTR(C.NEW_POD_YD_CD,1,5) " ).append("\n"); 
		query.append("         )       " ).append("\n"); 
		query.append(") C," ).append("\n"); 
		query.append("GL_MON_XCH_RT G," ).append("\n"); 
		query.append("(" ).append("\n"); 
		query.append("    SELECT MAX(ACCT_XCH_RT_YRMON) ACCT_XCH_RT_YRMON FROM" ).append("\n"); 
		query.append("    GL_MON_XCH_RT" ).append("\n"); 
		query.append("    WHERE 1=1" ).append("\n"); 
		query.append("    AND CURR_CD           = @[curr_cd]  " ).append("\n"); 
		query.append(") G2" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE A.CONTI_CD    =   C.CONTI_CD" ).append("\n"); 
		query.append("AND B.CONTI_CD      =   C.CONTI_CD" ).append("\n"); 
		query.append("AND A.DVS_FEE_TP_CD =   DECODE(SUBSTR(@[cgo_cate_cd],2,1),'2','2','4')" ).append("\n"); 
		query.append("AND B.DVS_FEE_TP_CD =   DECODE(C.CONTI_CD,'M','P','B')         -- P: BL, B: BOX " ).append("\n"); 
		query.append("AND A.DELT_FLG      =   'N'" ).append("\n"); 
		query.append("AND B.DELT_FLG      =   'N'" ).append("\n"); 
		query.append("AND G.CURR_CD           = @[curr_cd]   " ).append("\n"); 
		query.append("AND G.ACCT_XCH_RT_YRMON = G2.ACCT_XCH_RT_YRMON" ).append("\n"); 
		query.append("AND A.DIR_CD		=	@[skd_dir_cd]" ).append("\n"); 
		query.append("AND B.DIR_CD		=	@[skd_dir_cd]" ).append("\n"); 

	}
}