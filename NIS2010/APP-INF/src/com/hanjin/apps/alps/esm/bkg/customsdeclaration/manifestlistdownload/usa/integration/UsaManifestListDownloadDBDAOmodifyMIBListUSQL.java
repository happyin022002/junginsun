/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : UsaManifestListDownloadDBDAOmodifyMIBListUSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2010.04.29
*@LastModifier : 
*@LastVersion : 1.0
* 2010.04.29 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class UsaManifestListDownloadDBDAOmodifyMIBListUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * dwkim, 0408, IBD 에 L.Usa, Entry_type, inbond_type등을 갱신하기 위함.
	  * </pre>
	  */
	public UsaManifestListDownloadDBDAOmodifyMIBListUSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("cstms_clr_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("ibd_trsp_tp_cd",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("locl_clr_ipi_mvmt_flg",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bl_no",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.integration").append("\n"); 
		query.append("FileName : UsaManifestListDownloadDBDAOmodifyMIBListUSQL").append("\n"); 
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
		query.append("UPDATE BKG_CSTMS_ADV_IBD" ).append("\n"); 
		query.append("SET" ).append("\n"); 
		query.append("#if (${ibflag} == '0034')" ).append("\n"); 
		query.append("IBD_TRSP_TP_CD = @[ibd_trsp_tp_cd]" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("CNT_CD = CNT_CD" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${origin_bl_flag} == 'origin_bl')" ).append("\n"); 
		query.append(",CSTMS_CLR_TP_CD = @[cstms_clr_tp_cd]" ).append("\n"); 
		query.append(",IBD_TRSP_TP_CD = DECODE(@[cstms_clr_tp_cd], 'L', '', @[ibd_trsp_tp_cd]) -- Changed by L, then will be ''" ).append("\n"); 
		query.append(",IBD_TRSP_NO = DECODE(CSTMS_CLR_TP_CD, 	@[cstms_clr_tp_cd], IBD_TRSP_NO, -- No Change" ).append("\n"); 
		query.append("DECODE(@[cstms_clr_tp_cd], 'L', '', IBD_TRSP_NO)) -- Changed by L, then will be ''" ).append("\n"); 
		query.append("#else" ).append("\n"); 
		query.append("#if (${cstms_clr_tp_cd_chg} == 'Y')" ).append("\n"); 
		query.append(",CSTMS_CLR_TP_CD = @[cstms_clr_tp_cd]" ).append("\n"); 
		query.append("#if (${locl_clr_ipi_mvmt_flg} == 'Y' and ${cstms_clr_tp_cd} == 'L')" ).append("\n"); 
		query.append(",IBD_TRSP_NO = ''" ).append("\n"); 
		query.append(",IBD_TRSP_TP_CD = ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#if (${ibd_trsp_tp_cd_chg} == 'Y')" ).append("\n"); 
		query.append(",IBD_TRSP_TP_CD = DECODE(@[cstms_clr_tp_cd], 'L', '', @[ibd_trsp_tp_cd]) -- Changed by L, then will be ''" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("#if (${locl_clr_ipi_mvmt_flg} != '')" ).append("\n"); 
		query.append(",LOCL_CLR_IPI_MVMT_FLG = @[locl_clr_ipi_mvmt_flg]" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("#end" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("WHERE CNT_CD = 'US'" ).append("\n"); 
		query.append("AND BL_NO = @[bl_no]" ).append("\n"); 

	}
}