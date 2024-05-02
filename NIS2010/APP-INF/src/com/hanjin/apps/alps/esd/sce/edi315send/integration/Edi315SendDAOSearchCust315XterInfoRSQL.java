/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : Edi315SendDAOSearchCust315XterInfoRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.25
*@LastModifier : 
*@LastVersion : 1.0
* 2013.07.25 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.edi315send.integration ;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author 
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class Edi315SendDAOSearchCust315XterInfoRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * BKG에서 I_BKG_INFO 의 정보를 가져온다
	  * </pre>
	  */
	public Edi315SendDAOSearchCust315XterInfoRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("rqst_seq",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("sender_id",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.edi315send.integration ").append("\n"); 
		query.append("FileName : Edi315SendDAOSearchCust315XterInfoRSQL").append("\n"); 
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
		query.append("SELECT	'{I_BKG_INFO'											||CHR(10)||" ).append("\n"); 
		query.append("'IB_EDI_ORG_ID:'||NVL(mst.ACT_CUST_REF_NO, ' ')			||CHR(10)||" ).append("\n"); 
		query.append("'IB_EDI_ID:'	||NVL(mst.xter_sndr_id, ' ')			||CHR(10)||" ).append("\n"); 
		query.append("'IB_POL_CD:'    ||NVL(mst.POL_CD, ' ')      			||CHR(10)||" ).append("\n"); 
		query.append("'IB_POD_CD:'    ||NVL(mst.POD_CD, ' ')      			||CHR(10)||" ).append("\n"); 
		query.append("'IB_PICKUP_DT:'	||TO_CHAR(mst.mty_pkup_DT, 'RRRRMMDD')	||CHR(10)||" ).append("\n"); 
		query.append("'IB_ARV_R_DT:'	||TO_CHAR(mst.RQST_ARR_DT, 'RRRRMMDD')	||CHR(10)||" ).append("\n"); 
		query.append("'CNTRTS_CD:'	||NVL(qty.CNTR_tpsz_CD, ' ')			||CHR(10)||" ).append("\n"); 
		query.append("'IBI_POR_CD:'	||NVL(inst.POR_CTNT, ' ')				||CHR(10)||" ).append("\n"); 
		query.append("'IBI_POR_NM:'	||NVL(inst.POR_NM,   ' ')				||CHR(10)||" ).append("\n"); 
		query.append("'IBI_POL_CD:'	||NVL(inst.POL_CTNT, ' ') 				||CHR(10)||" ).append("\n"); 
		query.append("'IBI_POL_NM:'	||NVL(inst.POL_NM, ' ') 				||CHR(10)||" ).append("\n"); 
		query.append("'IBI_POD_CD:'	||NVL(inst.POD_CTNT, ' ') 				||CHR(10)||" ).append("\n"); 
		query.append("'IBI_POD_NM:'	||NVL(inst.POD_NM, ' ') 				||CHR(10)||" ).append("\n"); 
		query.append("'IBI_DEL_CD:'	||NVL(inst.DEL_CTNT, ' ')				||CHR(10)||" ).append("\n"); 
		query.append("'IBI_DEL_NM:'	||NVL(inst.DEL_NM,   ' ')				||CHR(10)||" ).append("\n"); 
		query.append("'IBI_TRANS_IND:'||NVL(inst.TRNS_IND_CTNT, ' ') 			||CHR(10)||" ).append("\n"); 
		query.append("'}I_BKG_INFO' I_BKG_INFO" ).append("\n"); 
		query.append("FROM bkg_xter_rqst_mst mst" ).append("\n"); 
		query.append(", bkg_xter_QTY qty" ).append("\n"); 
		query.append(", bkg_xter_instr inst" ).append("\n"); 
		query.append(", bkg_booking bkg" ).append("\n"); 
		query.append("where mst.xter_sndr_id  = qty.xter_sndr_id  (+)" ).append("\n"); 
		query.append("and mst.xter_rqst_no  = qty.xter_rqst_no  (+)" ).append("\n"); 
		query.append("and mst.xter_rqst_seq = qty.xter_rqst_seq (+)" ).append("\n"); 
		query.append("and mst.xter_sndr_id  = inst.xter_sndr_id (+)" ).append("\n"); 
		query.append("and mst.xter_rqst_no  = inst.xter_rqst_no (+)" ).append("\n"); 
		query.append("and mst.xter_rqst_seq = inst.xter_rqst_seq(+)" ).append("\n"); 
		query.append("AND mst.xter_sndr_id  = @[sender_id]" ).append("\n"); 
		query.append("and mst.xter_rqst_no  = @[rqst_no]" ).append("\n"); 
		query.append("and mst.xter_rqst_seq = @[rqst_seq]" ).append("\n"); 
		query.append("and mst.bkg_no = bkg.bkg_no (+)" ).append("\n"); 

	}
}