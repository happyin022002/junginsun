/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.05.12
*@LastModifier : 정인선
*@LastVersion : 1.0
* 2016.05.12 정인선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author jung in sun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * SearchBkgTmlEdiBatch
	  * </pre>
	  */
	public GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("vvd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("edi_ref_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.integration").append("\n"); 
		query.append("FileName : GeneralBookingSearchDBDAOSearchBkgTmlEdiBatchRSQL").append("\n"); 
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
		query.append("SELECT DISTINCT BK.BKG_NO" ).append("\n"); 
		query.append("     , BK.BKG_STS_CD" ).append("\n"); 
		query.append("     , DECODE(BK.BKG_CGO_TP_CD, 'F', 'F', 'P', 'M') F_M" ).append("\n"); 
		query.append("     , VVD.VSL_CD||VVD.SKD_VOY_NO||VVD.SKD_DIR_CD FIRST_VVD" ).append("\n"); 
		query.append("     , (SELECT TO_CHAR(VPS_ETB_DT, 'YYYY-MM-DD')" ).append("\n"); 
		query.append("          FROM VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("         WHERE VVD.VSL_CD           = SKD.VSL_CD" ).append("\n"); 
		query.append("           AND VVD.SKD_VOY_NO       = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("           AND VVD.SKD_DIR_CD       = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("           AND VVD.POL_CD           = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("           AND VVD.pol_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ) ETB" ).append("\n"); 
		query.append("     , VVD.SLAN_CD LANE" ).append("\n"); 
		query.append("     , VVD.POL_CD" ).append("\n"); 
		query.append("     , VVD.POL_YD_CD" ).append("\n"); 
		query.append("     , BK.MY_FWRD_CD FWDR_CD" ).append("\n"); 
		query.append("     , BK.MY_FWRD_VSL_DESC VOYAGE" ).append("\n"); 
		query.append("     , DCHG.CVY_REF_NO CRN" ).append("\n"); 
		query.append("     , DCHG.UQ_VSL_ID_NO UVI" ).append("\n"); 
		query.append("     , TO_CHAR(BKG_CRE_DT, 'YYYY-MM-DD HH:MI') BKG_DATE" ).append("\n"); 
		query.append("     , BK.DOC_USR_ID BKG_STAFF" ).append("\n"); 
		query.append("     , (SELECT USR.USR_NM FROM COM_USER USR WHERE USR.USR_ID = BK.DOC_USR_ID) BKG_STAFF_NM" ).append("\n"); 
		query.append("  FROM BKG_BOOKING BK" ).append("\n"); 
		query.append("     , BKG_VVD VVD" ).append("\n"); 
		query.append("     , VSK_VSL_PORT_SKD SKD" ).append("\n"); 
		query.append("     , BKG_VSL_DCHG_YD DCHG" ).append("\n"); 
		query.append(" WHERE BK.BKG_NO = VVD.BKG_NO" ).append("\n"); 
		query.append("   AND VVD.POL_YD_CD 		= @[edi_ref_cd]" ).append("\n"); 
		query.append("   AND BK.BKG_STS_CD        <> 'X'" ).append("\n"); 
		query.append("   AND BK.BKG_CGO_TP_CD 	IN('F','R')" ).append("\n"); 
		query.append("   AND VVD.VSL_CD           = DCHG.VSL_CD(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO       = DCHG.SKD_VOY_NO(+)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD       = DCHG.SKD_DIR_CD(+)" ).append("\n"); 
		query.append("   AND VVD.POL_CD           = DCHG.PORT_CD(+)" ).append("\n"); 
		query.append("   AND VVD.pol_CLPT_IND_SEQ = DCHG.CLPT_IND_SEQ(+)" ).append("\n"); 
		query.append("   AND VVD.VSL_CD           = SKD.VSL_CD" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO       = SKD.SKD_VOY_NO" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD       = SKD.SKD_DIR_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CD           = SKD.VPS_PORT_CD" ).append("\n"); 
		query.append("   AND VVD.POL_CLPT_IND_SEQ = SKD.CLPT_IND_SEQ" ).append("\n"); 
		query.append("   AND SKD.VPS_ETD_DT BETWEEN trunc(SYSDATE) AND trunc(SYSDATE) + 20" ).append("\n"); 
		query.append("#if (${vvd} != '')" ).append("\n"); 
		query.append("   AND VVD.VSL_CD = substr(@[vvd],1,4)" ).append("\n"); 
		query.append("   AND VVD.SKD_VOY_NO = substr(@[vvd],5,4)" ).append("\n"); 
		query.append("   AND VVD.SKD_DIR_CD = substr(@[vvd],9,1)" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}