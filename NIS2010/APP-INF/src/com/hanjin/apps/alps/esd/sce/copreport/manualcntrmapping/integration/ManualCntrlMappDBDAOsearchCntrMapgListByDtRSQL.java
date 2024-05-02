/*=========================================================
*Copyright(c) 2017 CyberLogitec
*@FileName : ManualCntrlMappDBDAOsearchCntrMapgListByDtRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2017.01.23
*@LastModifier : 홍성필
*@LastVersion : 1.0
* 2017.01.23 홍성필
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Hong Seong Pil
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class ManualCntrlMappDBDAOsearchCntrMapgListByDtRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * searchCntrMapgList
	  * </pre>
	  */
	public ManualCntrlMappDBDAOsearchCntrMapgListByDtRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgcrt_fm_dt",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bkgcrt_to_dt",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esd.sce.copreport.manualcntrmapping.integration").append("\n"); 
		query.append("FileName : ManualCntrlMappDBDAOsearchCntrMapgListByDtRSQL").append("\n"); 
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
		query.append("SELECT /*+ index( hdr XAK4SCE_COP_HDR ) */					                                                								" ).append("\n"); 
		query.append(" 	   distinct(bkg.bkg_no) bkg_no                                                                          " ).append("\n"); 
		query.append(" 	  ,cntr.cntr_no cntr_no                                                                                   " ).append("\n"); 
		query.append(" 	  ,cntr.cntr_tpsz_cd cntr_tpsz_cd                                                                             " ).append("\n"); 
		query.append(" 	  ,to_char(bkg.bkg_cre_dt,'YYYY/MM/DD HH24:MI:SS') bkg_cre_dt                                           " ).append("\n"); 
		query.append("     , '' AS nis_event_dt --TO_CHAR(cntr.NIS_EVNT_DT,'YYYY/MM/DD HH24:MI:SS') nis_evnt_dt       " ).append("\n"); 
		query.append("     , cntr.cntr_vol_qty cntr_vol_qty                                      " ).append("\n"); 
		query.append("     , cntr.rcv_term_cd cntr_rcv_term_cd                              " ).append("\n"); 
		query.append("     , cntr.de_term_cd cntr_de_term_cd                                                                 " ).append("\n"); 
		query.append(" 	  ,'A' dist                                                                                                " ).append("\n"); 
		query.append("  FROM bkg_booking bkg" ).append("\n"); 
		query.append("     , bkg_container cntr" ).append("\n"); 
		query.append("     , sce_cop_hdr hdr                                                   " ).append("\n"); 
		query.append(" WHERE 1 = 1 " ).append("\n"); 
		query.append("   AND    bkg.bkg_no=cntr.bkg_no                                                                               " ).append("\n"); 
		query.append("   AND bkg.bkg_no=hdr.bkg_no                                                                               " ).append("\n"); 
		query.append("   AND hdr.cop_sts_cd in ( 'C', 'T', 'F', 'X', 'O')                                                        " ).append("\n"); 
		query.append("   AND bkg.bkg_sts_cd not in ( 'X' , 'S' )	                                                                " ).append("\n"); 
		query.append("   AND bkg.bkg_cgo_tp_cd <> 'P'										                                    " ).append("\n"); 
		query.append("   AND bkg.bkg_cre_dt between to_date(@[bkgcrt_fm_dt],'YYYY-MM-DD') and to_date(@[bkgcrt_to_dt],'YYYY-MM-DD') + 0.99999                                           " ).append("\n"); 
		query.append("   AND NOT EXISTS (																		                " ).append("\n"); 
		query.append(" 	                SELECT /*+ index( bkg XAK2BKG_BOOKING) index(hdr XAK1SCE_COP_HDR) */                    " ).append("\n"); 
		query.append(" 	                       hdr.bkg_no bkg_no,                                                                      " ).append("\n"); 
		query.append(" 	                       --hdr.bkg_no_split bkg_no_split,                                                          " ).append("\n"); 
		query.append(" 	                       hdr.cntr_no cntr_no,                                                                    " ).append("\n"); 
		query.append(" 	                       hdr.cntr_tpsz_cd tpsz_cd                                                                " ).append("\n"); 
		query.append(" 	                  FROM bkg_booking bkg" ).append("\n"); 
		query.append(" 	                     , sce_cop_hdr hdr                                                   " ).append("\n"); 
		query.append(" 	                 WHERE bkg.bkg_no=hdr.bkg_no                                                             " ).append("\n"); 
		query.append(" 		               and bkg.bkg_sts_cd not in ( 'X' , 'S' )	                                            " ).append("\n"); 
		query.append(" 		               and bkg.bkg_cgo_tp_cd <> 'P'										                " ).append("\n"); 
		query.append(" 		               and bkg.bkg_cre_dt between to_date(@[bkgcrt_fm_dt],'YYYY-MM-DD') and to_date(@[bkgcrt_to_dt],'YYYY-MM-DD') + 0.99999                               " ).append("\n"); 
		query.append(" 		               and hdr.cop_sts_cd in ( 'C', 'T', 'F', 'X', 'O')                                    " ).append("\n"); 
		query.append(" 		               and hdr.cntr_no=cntr.cntr_no                                                        " ).append("\n"); 
		query.append(" 		               and hdr.cntr_no <> 'SMCU0000000'                                                    " ).append("\n"); 
		query.append(" 	                )" ).append("\n"); 

	}
}