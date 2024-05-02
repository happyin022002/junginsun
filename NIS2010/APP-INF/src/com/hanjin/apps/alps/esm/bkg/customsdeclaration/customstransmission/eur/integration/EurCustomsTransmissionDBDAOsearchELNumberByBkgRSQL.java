/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EurCustomsTransmissionDBDAOsearchELNumberByBkgRSQL.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.11.27
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.11.27 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration;

import java.util.HashMap;
import org.apache.log4j.Logger;
import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Kyoung Jong Yun
 * @see DAO 참조
 * @since J2EE 1.6
 */

public class EurCustomsTransmissionDBDAOsearchELNumberByBkgRSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * EL Number를 조회한다.
	  * </pre>
	  */
	public EurCustomsTransmissionDBDAOsearchELNumberByBkgRSQL(){
		setQuery();
		params = new HashMap<String,String[]>();
		String tmp = null;
		String[] arrTmp = null;
		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("mrn_no",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("msncfm",new String[]{arrTmp[0],arrTmp[1]});

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
		params.put("blts",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bltp",new String[]{arrTmp[0],arrTmp[1]});

		tmp = java.sql.Types.VARCHAR + ",N";
		arrTmp = tmp.split(",");
		if(arrTmp.length !=2){
			throw new IllegalArgumentException();
		}
		params.put("bnd_cd",new String[]{arrTmp[0],arrTmp[1]});

		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.integration").append("\n"); 
		query.append("FileName : EurCustomsTransmissionDBDAOsearchELNumberByBkgRSQL").append("\n"); 
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
		query.append("SELECT" ).append("\n"); 
		query.append("@[mrn_no] || @[msncfm] ELNO" ).append("\n"); 
		query.append(",NVL(BBD.PCK_QTY, 0)    ELPK" ).append("\n"); 
		query.append(",NVL(BBD.PCK_TP_CD, '') ELPKU" ).append("\n"); 
		query.append(",NVL(BBD.ACT_WGT, 0)    ELWT" ).append("\n"); 
		query.append(",NVL(BBD.WGT_UT_CD, '') ELWTU" ).append("\n"); 
		query.append("FROM BKG_BOOKING BB" ).append("\n"); 
		query.append(",BKG_BL_DOC BBD" ).append("\n"); 
		query.append("WHERE BB.BKG_NO = BBD.BKG_NO" ).append("\n"); 
		query.append("AND   BB.BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   @[bnd_cd] = 'O'" ).append("\n"); 
		query.append("AND   @[blts] = 'R'" ).append("\n"); 
		query.append("AND   @[bltp] = 'C'" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("UNION ALL" ).append("\n"); 
		query.append("" ).append("\n"); 
		query.append("SELECT" ).append("\n"); 
		query.append("XPT_LIC_NO          ELNO" ).append("\n"); 
		query.append(",NVL(PCK_QTY, 0)    ELPK" ).append("\n"); 
		query.append(",NVL(PCK_TP_CD, '') ELPKU" ).append("\n"); 
		query.append(",NVL(MF_WGT, 0)     ELWT" ).append("\n"); 
		query.append(",NVL(WGT_UT_CD, '') ELWTU" ).append("\n"); 
		query.append("FROM BKG_XPT_IMP_LIC" ).append("\n"); 
		query.append("WHERE BKG_NO = @[bkg_no]" ).append("\n"); 
		query.append("AND   IO_BND_CD = 'O'" ).append("\n"); 
		query.append("AND   @[bnd_cd] = 'O'" ).append("\n"); 
		query.append("AND   @[blts] = 'E'" ).append("\n"); 
		query.append("AND   @[bltp] = 'C'" ).append("\n"); 

	}
}