/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : BLIssuanceDBDAOModifyOblRcvByIbdUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.10
*@LastModifier : 
*@LastVersion : 1.0
* 2010.03.10 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class BLIssuanceDBDAOModifyOblRcvByIbdUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * Original B/L 회수 여부와 상세 정보를 수정한다.
	  * </pre>
	  */
	public BLIssuanceDBDAOModifyOblRcvByIbdUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_doc_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_doc_rcv_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_otr_doc_rcv_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_doc_rcv_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_doc_cgor_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_doc_rcv_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("otr_doc_rcv_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("upd_usr_id",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_ofc_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("obl_rdem_knt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("del_cnt_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.integration").append("\n"); 
		query.append("FileName : BLIssuanceDBDAOModifyOblRcvByIbdUSQL").append("\n"); 
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
		query.append("UPDATE BKG_BL_ISS " ).append("\n"); 
		query.append("SET    UPD_DT             = SYSDATE" ).append("\n"); 
		query.append("     , UPD_USR_ID         = @[upd_usr_id]" ).append("\n"); 
		query.append("#if (${obl_rdem_flg} != 'Y')" ).append("\n"); 
		query.append("     , OBL_RDEM_FLG         = 'N'" ).append("\n"); 
		query.append("     , OBL_RDEM_UPD_USR_ID  = NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , OBL_RDEM_FLG         = 'Y'" ).append("\n"); 
		query.append("     , OBL_RDEM_UPD_USR_ID  = DECODE(OBL_RDEM_FLG, 'Y', OBL_RDEM_UPD_USR_ID, @[obl_rdem_usr_id])  -- already redempeted dose not update" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${obl_rdem_knt} == '0')" ).append("\n"); 
		query.append("     , OBL_RDEM_KNT         = 0" ).append("\n"); 
		query.append("     , OBL_RDEM_OFC_CD      = NULL" ).append("\n"); 
		query.append("     , OBL_RDEM_USR_ID      = NULL" ).append("\n"); 
		query.append("     , OBL_RDEM_DT          = NULL" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , OBL_RDEM_KNT         = TO_NUMBER(@[obl_rdem_knt])" ).append("\n"); 
		query.append("     , OBL_RDEM_OFC_CD      = DECODE(NVL(OBL_RDEM_KNT, 0), TO_NUMBER(@[obl_rdem_knt]), OBL_RDEM_OFC_CD, @[obl_rdem_ofc_cd])" ).append("\n"); 
		query.append("     , OBL_RDEM_USR_ID      = DECODE(NVL(OBL_RDEM_KNT, 0), TO_NUMBER(@[obl_rdem_knt]), OBL_RDEM_USR_ID, @[obl_rdem_usr_id])" ).append("\n"); 
		query.append("     , OBL_RDEM_DT          = TO_DATE(" ).append("\n"); 
		query.append("                              DECODE(NVL(OBL_RDEM_KNT, 0)" ).append("\n"); 
		query.append("                                     , TO_NUMBER(@[obl_rdem_knt]), TO_CHAR(OBL_RDEM_DT, 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("                                     , TO_CHAR(GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[obl_rdem_ofc_cd])), 'YYYYMMDDHH24MI')" ).append("\n"); 
		query.append("                                    ), 'YYYYMMDDHH24MISS')" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${bl_otr_doc_rcv_cd} != '')" ).append("\n"); 
		query.append("     , BL_OTR_DOC_RCV_CD  = @[bl_otr_doc_rcv_cd]" ).append("\n"); 
		query.append("     , OTR_DOC_RCV_OFC_CD = NVL(OTR_DOC_RCV_OFC_CD, @[otr_doc_rcv_ofc_cd])" ).append("\n"); 
		query.append("     , OTR_DOC_RCV_USR_ID = NVL(OTR_DOC_RCV_USR_ID, @[otr_doc_rcv_usr_id])" ).append("\n"); 
		query.append("     , OTR_DOC_RCV_DT     = NVL(OTR_DOC_RCV_DT    , GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[obl_rdem_ofc_cd])))" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , BL_OTR_DOC_RCV_CD  = NULL" ).append("\n"); 
		query.append("     , OTR_DOC_RCV_OFC_CD = NULL" ).append("\n"); 
		query.append("     , OTR_DOC_RCV_USR_ID = NULL" ).append("\n"); 
		query.append("     , OTR_DOC_RCV_DT     = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${otr_doc_cgor_flg} != '')" ).append("\n"); 
		query.append("     , OTR_DOC_CGOR_FLG   = @[otr_doc_cgor_flg]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("     , OTR_DOC_CGOR_FLG   = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${ibd_doc_rcv_flg} == 'Y')" ).append("\n"); 
		query.append("     , IBD_DOC_RCV_FLG    = @[ibd_doc_rcv_flg]" ).append("\n"); 
		query.append("     , IBD_DOC_RCV_OFC_CD = nvl(IBD_DOC_RCV_OFC_CD, @[ibd_doc_rcv_ofc_cd])" ).append("\n"); 
		query.append("     , IBD_DOC_RCV_USR_ID = nvl(IBD_DOC_RCV_USR_ID, @[ibd_doc_rcv_usr_id])" ).append("\n"); 
		query.append("     , IBD_DOC_RCV_DT     = nvl(IBD_DOC_RCV_DT    , GLOBALDATE_PKG.TIME_CONV_FNC('KRSEL', SYSDATE, GLOBALDATE_PKG.GET_LOCCD_FNC(@[obl_rdem_ofc_cd])) )" ).append("\n"); 
		query.append("#elseif (${ibd_doc_rcv_flg} == 'N')" ).append("\n"); 
		query.append("     , IBD_DOC_RCV_FLG    = @[ibd_doc_rcv_flg]" ).append("\n"); 
		query.append("     , IBD_DOC_RCV_OFC_CD = NULL" ).append("\n"); 
		query.append("     , IBD_DOC_RCV_USR_ID = NULL" ).append("\n"); 
		query.append("     , IBD_DOC_RCV_DT     = NULL" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append(" WHERE BKG_NO             = @[bkg_no]" ).append("\n"); 
		query.append("  AND 1 = (SELECT DECODE(SUBSTR(MAX(DEL_CD), 1,2)" ).append("\n"); 
		query.append("                          , 'IN', DECODE(@[del_cnt_cd], 'IN', 1, 0)  -- 인도의 경우 데이터가 안 들어올 것을 대비해서 이중 검증한다." ).append("\n"); 
		query.append("                          , COUNT(1)" ).append("\n"); 
		query.append("                        )" ).append("\n"); 
		query.append("             FROM BKG_BOOKING" ).append("\n"); 
		query.append("            WHERE BKG_NO = @[bkg_no] )" ).append("\n"); 

	}
}