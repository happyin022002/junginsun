/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailBillingVerifyList.java
*@FileTitle : Rail Billing Verify List
*Open Issues :
*Change history :
*@LastModifyDate : 2007-02-06
*@LastModifier : Lee Sang-Woo
*@LastVersion : 1.0
* 2007-02-06 Lee Sang-Woo
* 1.0 최초 생성
* S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
=========================================================*/
package com.clt.apps.opus.esd.trs.servicesio.sppcomplement.railbillingverifymanage.event;

import com.clt.apps.opus.esd.trs.servicesio.railbilling.common.Constants;

/**
 * RailBillingVerifyEventResponse 에 대한 WebService Document Object including Parameters<br>
 * - RailBillingIWSProxy의 Output Parameter<br>
 * - RailBillingVerifyEventResponse에서 변환하여 사용<br>
 *
 * @author Lee Sang-Woo
 * @see TrsSppIWSProxy 참조
 * @since J2EE 1.4
 */
public class RailBillingVerifyList {
	
	// retrun 파라미터
	private String railVrfyRstCd = Constants.VRFY_NOWRS;
	private	String eqNo  = null;
	private	String eqTpszCd  = null;
	private	String blkFlg  = null;
	private	String stlWireFlg  = null;
	private	String coilShpFlg   = null;
	private	String fmgtFlg   = null;
	private	String piece   = null;		//갯수
	private String weight = null;      // 무게 2007.05.18 추가
	private String usRegion = null;    // us 2007.07.02 추가
	private	String eqTpszNm  = null;  // nm 2007.07.02 추가

	private	String errMsgCd   = null;	// 에러 코드
	private	String errMsg   = null;	// S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	private	String langTpCd   = null; // ENG	

	// Full
	private	String copNo   = null;					    // cop 넘버
	private	String costActGrpSeq   = null;		    // cop 넘버
	private	String ydFctyTpMrnTmlFlg   = null;		// ydFctyTpMrnTmlFlg
	private	String pctlNo   = null;		// pctl_no
	private String tareWgt  = null;

	// Mty
	private	String routeOrgNodCd  = null;		// IRG
	private	String routeDestNodCd   = null;		// 
	private	String routeSeq   = null;				// 
	private	String railRoute   = null;				//

	private	String repoPlnId   = null;		// 
	private	String plnYrwk   = null;			// 
	private	String refId   = null;				// 
	private	String refSeq   = null;			//
	private	String toYard   = null;			//
	private String fmYdCd		= null;
	private String htKey		= null;
	
	private String isBlockVendor		= null;
	private String isGoodbill		= null;
	private String isConstrainted		= null;
	private String vndrSeq		= null;	// S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	
	public String getRailVrfyRstCd()        	{		return railVrfyRstCd ;          }
	public String getEq_no()                	{		return eqNo ;                 	}
	public String getEq_tpsz_cd()           	{		return eqTpszCd ;             }
	public String getBlk_flg()              	{		return blkFlg ;                }
	public String getStl_wire_flg()       		{		return stlWireFlg ;       	}
	public String getCoil_shp_flg()       		{		return coilShpFlg  ;       	}
	public String getFmgt_flg()             	{		return fmgtFlg  ;              }
	public String getPiece()              		{		return piece  ;              	}
	public String getWeight()              		{		return weight  ;              	}
	public String getUs_region()            	{		return usRegion  ;             }
	public String getEq_tpsz_nm()           	{		return eqTpszNm ;             }
	
	public String getErr_msg_cd()       		{		return errMsgCd  ;       		}	
	public String getErr_msg()       			{		return errMsg  ;       		}	// S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	public String getLang_tp_cd()           	{		return langTpCd  ;            }
	public String getCop_no()              		{		return copNo  ;              	}
	public String getCost_act_grp_seq()     	{		return costActGrpSeq ;       }
	public String getRoute_org_nod_cd()     	{		return routeOrgNodCd ;       }
	public String getRoute_dest_nod_cd()    	{		return routeDestNodCd ;      }	
	public String getRoute_seq()       			{		return routeSeq ;       		}
	public String getRail_route()       		{		return railRoute ;       		}	
	public String getRepo_pln_id()          	{		return repoPlnId ;            }
	public String getPln_yrwk()           		{		return plnYrwk ;               }	
	public String getRef_id()       			{		return refId ;       			}
	public String getRef_seq()       			{		return refSeq  ;       		}
	public String getTo_yard()       			{		return toYard  ;       		}
	public String getFm_yd_cd()             	{		return fmYdCd ;               }
	public String getYd_fcty_tp_mrn_tml_flg()	{		return ydFctyTpMrnTmlFlg ; }
	public String getVndr_seq()               	{		return vndrSeq ;               }	// S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	public String getPctlNo() 					{		return pctlNo;					}
	public String getTare_wgt() 				{		return tareWgt;					}
	
	
	public void	setRailVrfyRstCd     		(String	railVrfyRstCd			) {		this.railVrfyRstCd = railVrfyRstCd ;           			}
	public void	setEq_no            		(String	eqNo					) {		this.eqNo = eqNo ;           							}
	public void	setEq_tpsz_cd       		(String	eqTpszCd 				) {		this.eqTpszCd	= eqTpszCd ;           				}
	public void	setBlk_flg          		(String	blkFlg 				) {		this.blkFlg = blkFlg ;           						}
	public void	setStl_wire_flg     		(String	stlWireFlg   			) {		this.stlWireFlg = stlWireFlg ;       				}
	public void	setCoil_shp_flg     		(String	coilShpFlg			) {		this.coilShpFlg = coilShpFlg  ;       				}
	public void	setFmgt_flg         		(String	fmgtFlg      			) {		this.fmgtFlg = fmgtFlg  ;     						}
	public void	setPiece            		(String	piece      				) {		this.piece = piece  ;     								}
	public void	setWeight            		(String	weight      			) {		this.weight = weight  ;     							}
	public void	setUs_region            	(String	usRegion      			) {		this.usRegion = usRegion  ;     						}
	public void	setEq_tpsz_nm       		(String	eqTpszNm 				) {		this.eqTpszNm	= eqTpszNm ;           				}
	
	public void	setErr_msg_cd     			(String	errMsgCd				) {		this.errMsgCd	= errMsgCd  ;       					}
	public void	setErr_msg     				(String	errMsg					) {		this.errMsg	= errMsg  ;       						}	// S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	public void	setLang_tp_cd       		(String	langTpCd      		) {		this.langTpCd	= langTpCd  ;     					}
	public void	setCop_no           		(String	copNo      			) {		this.copNo	= copNo  ;     							}
	public void	setCost_act_grp_seq 		(String	costActGrpSeq		) {		this.costActGrpSeq = costActGrpSeq ;           	}
	public void	setRoute_org_nod_cd     	(String	routeOrgNodCd 		) {		this.routeOrgNodCd = routeOrgNodCd ;           	}
	public void	setRoute_dest_nod_cd    	(String	routeDestNodCd 		) {		this.routeDestNodCd	= routeDestNodCd ;           }
	public void	setRoute_seq     			(String	routeSeq   			) {		this.routeSeq = routeSeq ;       						}
	public void	setRail_route     			(String	railRoute   			) {		this.railRoute = railRoute ;       					}	
	public void	setRepo_pln_id      		(String	repoPlnId 			) {		this.repoPlnId = repoPlnId ;           				}
	public void	setPln_yrwk       			(String	plnYrwk 				) {		this.plnYrwk	= plnYrwk ;           					}
	public void	setRef_id     				(String	refId   				) {		this.refId = refId ;       							}
	public void	setRef_seq    				(String	refSeq					) {		this.refSeq = refSeq  ;       						}
	public void	setTo_yard    				(String	toYard					) {		this.toYard = toYard  ;       						}
	public void	setFm_yd_cd             	(String	fmYdCd 				) {		this.fmYdCd = fmYdCd ;           					}
	public void	setYd_fcty_tp_mrn_tml_flg   (String	ydFctyTpMrnTmlFlg 	) {		this.ydFctyTpMrnTmlFlg = ydFctyTpMrnTmlFlg ;	}
	public void	setVndr_seq           		(String	vndrSeq 				) {		this.vndrSeq = vndrSeq ;           					}	// S1L-09U-003 2009-06-10 Rail Export Cargo Available Return Time 개발
	public void setPctlNo					(String pctlNo					) { 	this.pctlNo = pctlNo;									}
	public void setTare_wgt					(String tareWgt					) { 	this.tareWgt = tareWgt;									}
	
	/**
	 * @return Returns the htKey.
	 */
	public String getHt_key() {
		return htKey;
	}
	/**
	 * @param htKey The htKey to set.
	 */
	public void setHt_key(String htKey) {
		this.htKey = htKey;
	}
	/**
	 * @return Returns the isBlockVendor.
	 */
	public String getIs_block_vendor() {
		return isBlockVendor;
	}
	/**
	 * @param isBlockVendor The isBlockVendor to set.
	 */
	public void setIs_block_vendor(String isBlockVendor) {
		this.isBlockVendor = isBlockVendor;
	}
	/**
	 * @return Returns the isConstrainted.
	 */
	public String getIs_constrainted() {
		return isConstrainted;
	}
	/**
	 * @param isConstrainted The isConstrainted to set.
	 */
	public void setIs_constrainted(String isConstrainted) {
		this.isConstrainted = isConstrainted;
	}
	/**
	 * @return Returns the isGoodbill.
	 */
	public String getIs_goodbill() {
		return isGoodbill;
	}
	/**
	 * @param isGoodbill The isGoodbill to set.
	 */
	public void setIs_goodbill(String isGoodbill) {
		this.isGoodbill = isGoodbill;
	}
	
}
