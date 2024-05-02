/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : GeneralBookingReceiptDBDAOSearchBlockStowageRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2016.11.23
*@LastModifier : 
*@LastVersion : 1.0
* 2016.11.23 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class GeneralBookingReceiptDBDAOSearchBlockStowageRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BS 설정 순위 지정
	  * </pre>
	  */
	public GeneralBookingReceiptDBDAOSearchBlockStowageRSQL(){
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
		query.append("Path : com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.integration").append("\n"); 
		query.append("FileName : GeneralBookingReceiptDBDAOSearchBlockStowageRSQL").append("\n"); 
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
		query.append("SELECT BLCK_STWG_CD" ).append("\n"); 
		query.append("FROM (" ).append("\n"); 
		query.append("  SELECT PCTL_SEQ, BLCK_STWG_CD" ).append("\n"); 
		query.append("  FROM (" ).append("\n"); 
		query.append("      SELECT PCT.PCTL_SEQ+1000-DECODE(A.HUB_LOC_CD,SUBSTR(B.ROUT_DEST_NOD_CD,1,5),100,0) - DECODE(B.ROUT_SEQ, PCT.ROUT_SEQ, 0.1, 0) AS PCTL_SEQ, SUBSTR(PCT.ORG_NOD_CD,1,5), SUBSTR(PCT.DEST_NOD_CD,1,5), a.blck_stwg_cd" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("           ,PRD_PROD_CTL_ROUT_DTL PCT" ).append("\n"); 
		query.append("           ,prd_blck_stwg a, prd_inlnd_rout_mst b" ).append("\n"); 
		query.append("      WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND PCT.PCTL_NO = BB.PCTL_NO" ).append("\n"); 
		query.append("      AND PCT.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("      AND PCT.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("      AND a.port_cd = substr(b.rout_org_nod_cd,1,5)" ).append("\n"); 
		query.append("      AND a.hub_loc_cd = DECODE(substr(b.hub_nod_cd,1,5),NULL,substr(b.rout_org_nod_cd,1,5),substr(b.hub_nod_cd,1,5))" ).append("\n"); 
		query.append("      AND b.inlnd_rout_bkg_flg ='Y'" ).append("\n"); 
		query.append("      AND NVL(b.delt_flg, 'N') <>'Y'" ).append("\n"); 
		query.append("      AND a.port_cd LIKE BB.POD_CD || '%'" ).append("\n"); 
		query.append("      AND b.rout_dest_nod_cd LIKE BB.DEL_CD || '%'" ).append("\n"); 
		query.append("      AND b.pctl_io_bnd_cd = 'I'" ).append("\n"); 
		query.append("      AND A.VSL_SLAN_CD          = (SELECT BV.SLAN_CD FROM BKG_VVD BV WHERE BV.BKG_NO = BB.BKG_NO AND BV.POD_CD = BB.POD_CD AND ROWNUM = 1)" ).append("\n"); 
		query.append("      UNION ALL" ).append("\n"); 
		query.append("      SELECT PCT.PCTL_SEQ+5000-DECODE(A.HUB_LOC_CD,SUBSTR(B.ROUT_DEST_NOD_CD,1,5),100,0) - DECODE(B.ROUT_SEQ, PCT.ROUT_SEQ, 0.1, 0), SUBSTR(PCT.ORG_NOD_CD,1,5), SUBSTR(PCT.DEST_NOD_CD,1,5), a.blck_stwg_cd" ).append("\n"); 
		query.append("      FROM BKG_BOOKING BB" ).append("\n"); 
		query.append("           ,PRD_PROD_CTL_ROUT_DTL PCT" ).append("\n"); 
		query.append("           ,prd_blck_stwg a, prd_inlnd_rout_mst b" ).append("\n"); 
		query.append("      WHERE BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("      AND PCT.PCTL_NO = BB.PCTL_NO" ).append("\n"); 
		query.append("      AND PCT.TRSP_MOD_CD <> 'X'" ).append("\n"); 
		query.append("      AND PCT.PCTL_IO_BND_CD = 'I'" ).append("\n"); 
		query.append("      AND a.port_cd = substr(b.rout_org_nod_cd,1,5)" ).append("\n"); 
		query.append("      AND a.hub_loc_cd = DECODE(substr(b.hub_nod_cd,1,5),NULL,substr(b.rout_org_nod_cd,1,5),substr(b.hub_nod_cd,1,5))" ).append("\n"); 
		query.append("      AND b.inlnd_rout_bkg_flg ='Y'" ).append("\n"); 
		query.append("      AND NVL(b.delt_flg, 'N') <>'Y'" ).append("\n"); 
		query.append("      AND a.port_cd LIKE BB.POD_CD || '%'" ).append("\n"); 
		query.append("      AND b.rout_dest_nod_cd LIKE BB.DEL_CD || '%'" ).append("\n"); 
		query.append("      AND b.pctl_io_bnd_cd = 'I'" ).append("\n"); 
		query.append("      AND A.VSL_SLAN_CD          = 'ALL'" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  ORDER BY PCTL_SEQ" ).append("\n"); 
		query.append(")" ).append("\n"); 
		query.append("WHERE ROWNUM  = 1" ).append("\n"); 

	}
}