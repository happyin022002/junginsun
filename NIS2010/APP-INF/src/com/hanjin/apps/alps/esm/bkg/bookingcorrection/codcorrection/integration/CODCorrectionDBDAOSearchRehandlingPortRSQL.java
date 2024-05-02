/*=========================================================
*Copyright(c) 2018 CyberLogitec
*@FileName : CODCorrectionDBDAOSearchRehandlingPortRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2018.01.09
*@LastModifier : 
*@LastVersion : 1.0
* 2018.01.09 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class CODCorrectionDBDAOSearchRehandlingPortRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 해당 Cod Request 건의 rehandling Request를 판단한다.
	  * </pre>
	  */
	public CODCorrectionDBDAOSearchRehandlingPortRSQL(){
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
		params.put("pctl_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cod_rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.bookingcorrection.codcorrection.integration").append("\n"); 
		query.append("FileName : CODCorrectionDBDAOSearchRehandlingPortRSQL").append("\n"); 
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
		query.append("WITH MST AS (" ).append("\n"); 
		query.append("SELECT MAX(PCTL_SEQ) LAST_SEQ --마지막으로 같은 VVD의 prd detail route상 seq" ).append("\n"); 
		query.append("#if(${cod_rqst_seq}=='')" ).append("\n"); 
		query.append("  FROM BKG_VVD VVD" ).append("\n"); 
		query.append("     , PRD_PROD_CTL_ROUT_DTL LAST_VVD                " ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO       = @[bkg_no]    --변경전 ROUTE와 " ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("  FROM BKG_COD_VVD VVD" ).append("\n"); 
		query.append("     , PRD_PROD_CTL_ROUT_DTL LAST_VVD                " ).append("\n"); 
		query.append(" WHERE VVD.BKG_NO       = @[bkg_no]    --변경전 ROUTE와 " ).append("\n"); 
		query.append("   AND VVD.COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 
		query.append("   AND VVD.VVD_OP_CD    = 'O'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("   AND LAST_VVD.PCTL_NO = @[pctl_no]   --NEW ROUTE" ).append("\n"); 
		query.append("   AND TRSP_MOD_CD      in ('VD', 'WD')--배를 탐" ).append("\n"); 
		query.append("   AND PCTL_IO_BND_CD   = 'T'          --T/S구간" ).append("\n"); 
		query.append("   AND VVD.VSL_CD       = LAST_VVD.VSL_CD    " ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO   = LAST_VVD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD   = LAST_VVD.SKD_DIR_CD)            " ).append("\n"); 
		query.append("SELECT CASE WHEN MST.LAST_SEQ > 0 THEN --같은 VVD가 있을 경우" ).append("\n"); 
		query.append("                (SELECT REHANDLING_PORT--먼저 CALLING하는 PORT" ).append("\n"); 
		query.append("                  FROM (SELECT NVL(SKD.YD_CD, DTL.ORG_NOD_CD) REHANDLING_PORT" ).append("\n"); 
		query.append("#if(${cod_rqst_seq}=='')" ).append("\n"); 
		query.append("                          FROM BKG_VVD VVD" ).append("\n"); 
		query.append("                                , PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                                , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                , MST" ).append("\n"); 
		query.append("                         WHERE VVD.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("                          FROM BKG_COD_VVD VVD" ).append("\n"); 
		query.append("                                , PRD_PROD_CTL_ROUT_DTL DTL" ).append("\n"); 
		query.append("                                , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("                                , MST" ).append("\n"); 
		query.append("                         WHERE VVD.BKG_NO     = @[bkg_no]" ).append("\n"); 
		query.append("						   AND VVD.COD_RQST_SEQ = @[cod_rqst_seq]" ).append("\n"); 
		query.append("						   AND VVD.VVD_OP_CD    = 'O'" ).append("\n"); 
		query.append("#end                                           " ).append("\n"); 
		query.append("                           AND DTL.PCTL_NO    = @[pctl_no]" ).append("\n"); 
		query.append("                           AND DTL.PCTL_SEQ   = MST.LAST_SEQ" ).append("\n"); 
		query.append("                           AND VVD.VSL_CD     = SKD.VSL_CD" ).append("\n"); 
		query.append("                           AND VVD.SKD_VOY_NO = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("                           AND VVD.SKD_DIR_CD = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("		                   AND VVD.VSL_CD     = DTL.VSL_CD" ).append("\n"); 
		query.append("        		           AND VVD.SKD_VOY_NO = DTL.SKD_VOY_NO" ).append("\n"); 
		query.append("                		   AND VVD.SKD_DIR_CD = DTL.SKD_DIR_CD" ).append("\n"); 
		query.append("                           AND SKD.VPS_PORT_CD IN (SUBSTR(VVD.POD_YD_CD, 1, 5), SUBSTR(DTL.DEST_NOD_CD, 1, 5))--OLD OR NEW PORT 중에" ).append("\n"); 
		query.append("                         ORDER BY DECODE(SKD.YD_CD,VVD.POD_YD_CD,1,2), SKD.VPS_ETD_DT) " ).append("\n"); 
		query.append("                 WHERE ROWNUM = 1) " ).append("\n"); 
		query.append("            ELSE                       --같은 VVD가 없을 경우" ).append("\n"); 
		query.append("                (SELECT POL_NOD_CD     --최초 loading port" ).append("\n"); 
		query.append("                   FROM BKG_BOOKING " ).append("\n"); 
		query.append("                  WHERE BKG_NO = @[bkg_no]) END REHANDLING_PORT" ).append("\n"); 
		query.append("  FROM MST" ).append("\n"); 

	}
}