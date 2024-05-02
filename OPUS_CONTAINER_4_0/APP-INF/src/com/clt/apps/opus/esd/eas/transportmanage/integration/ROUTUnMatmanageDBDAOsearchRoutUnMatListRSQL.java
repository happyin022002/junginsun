/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ROUTUnMatmanageDBDAOsearchRoutUnMatListRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.04
*@LastModifier : 양봉준
*@LastVersion : 1.0
* 2010.04.04 양봉준
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.eas.transportmanage.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;

import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author Bongjun Yang
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ROUTUnMatmanageDBDAOsearchRoutUnMatListRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Route UnMatch List 조회
	  * </pre>
	  */
	public ROUTUnMatmanageDBDAOsearchRoutUnMatListRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("fromsodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("tosodate",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("somonth",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("dest",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ctrl_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("s_bnd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("org",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.eas.transportmanage.integration").append("\n"); 
		query.append("FileName : ROUTUnMatmanageDBDAOsearchRoutUnMatListRSQL").append("\n"); 
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
		query.append("SELECT  DISTINCT '' seq, B.VSL_CD||B.SKD_VOY_NO||B.SKD_DIR_CD||B.SLAN_CD vvd," ).append("\n"); 
		query.append("D.BKG_NO bkg_no, D.BKG_STS_CD bkg_status, D.BL_NO||D.BL_NO_TP bl_no," ).append("\n"); 
		query.append("B.TRSP_BND_CD bound," ).append("\n"); 
		query.append("DECODE(B.TRSP_BND_CD,'I',D.DE_TERM_CD,'O',D.RCV_TERM_CD) term," ).append("\n"); 
		query.append("D.POR_CD bkg_por, D.POL_CD bkg_pol, D.POD_CD bkg_pod, D.DEL_CD bkg_del," ).append("\n"); 
		query.append("DECODE(B.TRSP_BND_CD,'O',B.POR_CD,B.POD_CD) so_from," ).append("\n"); 
		query.append("B.VIA_NOD_CD so_via," ).append("\n"); 
		query.append("DECODE(B.TRSP_BND_CD,'O',B.POL_CD,B.DEL_CD) so_to," ).append("\n"); 
		query.append("B.TRSP_COST_DTL_MOD_CD trans_mode, C.CRE_OFC_CD so_ofc_cd," ).append("\n"); 
		query.append("DECODE(NVL(E.RMK_CTNT, '0'), '0', 'No'," ).append("\n"); 
		query.append("'Yes') rmk_ctnt" ).append("\n"); 
		query.append("FROM TRS_TRSP_SVC_ORD B, TRS_TRSP_WRK_ORD C, BKG_BOOKING D, TRS_EXPN_AUD_RMK E" ).append("\n"); 
		query.append("WHERE 1=1" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${search_choice}=='MM')" ).append("\n"); 
		query.append("AND TO_CHAR(B.LOCL_CRE_DT,'yyyymm') = @[somonth]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("AND B.LOCL_CRE_DT >= TO_DATE(@[fromsodate],'YYYYMMDD')" ).append("\n"); 
		query.append("AND B.LOCL_CRE_DT <= TO_DATE(@[tosodate],'YYYYMMDD')" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND B.INV_NO is not null" ).append("\n"); 
		query.append("AND B.TRSP_WO_OFC_CTY_CD = C.TRSP_WO_OFC_CTY_CD" ).append("\n"); 
		query.append("AND B.TRSP_WO_SEQ = C.TRSP_WO_SEQ" ).append("\n"); 
		query.append("AND B.BKG_NO = D.BKG_NO" ).append("\n"); 
		query.append("AND B.BKG_NO = E.BKG_NO(+)" ).append("\n"); 
		query.append("AND 'RU' = E.EAS_EXPN_TP_CD(+)" ).append("\n"); 
		query.append("AND B.TRSP_BND_CD IN ('I','O')" ).append("\n"); 
		query.append("AND ( DECODE(B.TRSP_BND_CD,'O',D.POR_CD,D.POD_CD) <> DECODE(B.TRSP_BND_CD,'O',B.POR_CD,B.POD_CD)" ).append("\n"); 
		query.append("OR DECODE(B.TRSP_BND_CD,'O',D.POL_CD,D.DEL_CD) <> DECODE(B.TRSP_BND_CD,'O',B.POL_CD,B.DEL_CD)	)" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("AND C.CRE_OFC_CD = @[ctrl_ofc_cd]" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${s_bnd} !='' )" ).append("\n"); 
		query.append("AND B.TRSP_BND_CD like @[s_bnd]||'%'" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${org} !='' )" ).append("\n"); 
		query.append("AND D.POL_CD = @[org]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${dest} !='' )" ).append("\n"); 
		query.append("AND D.POD_CD = @[dest]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if ( ${ctrl_ofc_cd} !='')" ).append("\n"); 
		query.append("ORDER BY SEQ, VVD, BKG_NO, BKG_STATUS, BL_NO" ).append("\n"); 
		query.append("#end" ).append("\n"); 

	}
}