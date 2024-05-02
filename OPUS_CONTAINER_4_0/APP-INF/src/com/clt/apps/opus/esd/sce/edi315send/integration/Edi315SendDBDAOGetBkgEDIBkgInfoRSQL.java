/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : Edi315SendDBDAOGetBkgEDIBkgInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.06.18
*@LastModifier : 
*@LastVersion : 1.0
* 2015.06.18 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.sce.edi315send.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.clt.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDBDAOGetBkgEDIBkgInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * GetBkgEDIBkgInfo
	  * </pre>
	  */
	public Edi315SendDBDAOGetBkgEDIBkgInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("e_bkg_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.clt.apps.opus.esd.sce.edi315send.integration").append("\n"); 
		query.append("FileName : Edi315SendDBDAOGetBkgEDIBkgInfoRSQL").append("\n"); 
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
		query.append("SELECT '{I_BKG_INFO'           ||CHR(10)||" ).append("\n"); 
		query.append("        'IBI_POR_CD : ' ||NVL(POR_CTNT, ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("        'IBI_POR_CD_TP_CD : ' ||NVL(XTER_POR_TP_CD, ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("        'IBI_POR_NM : ' ||NVL(POR_NM,   ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("        'IBI_POL_CD : '    ||NVL(POL_CD, ' ')         ||CHR(10)||" ).append("\n"); 
		query.append("        'IBI_POL_CD_TP_CD : '    ||NVL(XTER_POL_TP_CD, ' ')         ||CHR(10)||" ).append("\n"); 
		query.append("        'IBI_POL_NM : ' ||NVL(POL_NM,   ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("  'IBI_POD_CD :' ||NVL(POD_CTNT, ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("  'IBI_POD_CD_TP_CD :' ||NVL(XTER_POD_TP_CD, ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("  'IBI_POD_NM : ' ||NVL(POD_NM,   ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("  'IBI_DEL_CD : ' ||NVL(DEL_CTNT, ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("  'IBI_DEL_CD_TP_CD : ' ||NVL(XTER_DEL_TP_CD, ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("  'IBI_DEL_NM : ' ||NVL(DEL_NM,   ' ')    ||CHR(10)||" ).append("\n"); 
		query.append("    '}I_BKG_INFO'||CHR(10) I_BKG_INFO, rqst_dt" ).append("\n"); 
		query.append("  FROM(" ).append("\n"); 
		query.append("  SELECT inst.POR_CTNT, inst.POR_NM, mst.POL_CD,inst.POL_NM, inst.POD_CTNT," ).append("\n"); 
		query.append("         inst.POD_NM, inst.DEL_CTNT, inst.DEL_NM, mst.rqst_dt," ).append("\n"); 
		query.append("         inst.xter_por_tp_cd, inst.xter_pol_tp_cd, inst.xter_pod_tp_cd, inst.xter_del_tp_cd" ).append("\n"); 
		query.append("  FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append("        , bkg_xter_QTY qty" ).append("\n"); 
		query.append("        , bkg_xter_instr inst" ).append("\n"); 
		query.append(" where mst.xter_sndr_id  = qty.xter_sndr_id  (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_no  = qty.xter_rqst_no  (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq = qty.xter_rqst_seq (+)" ).append("\n"); 
		query.append("   and mst.xter_sndr_id  = inst.xter_sndr_id (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_no  = inst.xter_rqst_no (+)" ).append("\n"); 
		query.append("   and mst.xter_rqst_seq = inst.xter_rqst_seq(+)" ).append("\n"); 
		query.append("   AND mst.bkg_no        = @[e_bkg_no]" ).append("\n"); 
		query.append("   --and mst.DOC_TP_CD     = 'B'" ).append("\n"); 
		query.append("  -- and mst.XTER_SNDR_ID  <> 'WEB'" ).append("\n"); 
		query.append("  -- and BKG_UPLD_STS_CD   = 'F'" ).append("\n"); 
		query.append("   ORDER BY mst.rqst_dt DESC" ).append("\n"); 
		query.append("  )" ).append("\n"); 
		query.append("  WHERE ROWNUM = 1" ).append("\n"); 

	}
}